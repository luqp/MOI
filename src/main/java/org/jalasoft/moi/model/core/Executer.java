/**
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.ProcessResult;
import org.jalasoft.moi.model.core.parameters.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

/**
 * Class receives a string, executes it on cmd and returns output on a string.
 *
 * @author Mauricio Oroza
 *         Lucero Quiroga Perez
 * @version 1.2
 */
public class Executer {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    private ICacheProvider cache;
    private Result result;

    public Executer(ICacheProvider cache) {
        this.cache = cache;
        this.result = new ProcessResult();
    }

    /**
     * Executes command in cmd.
     *
     * @return The output of the console in one string in the form: String1 + \n + String1 + \n + ...
     */
    public Result execute(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        LOGGER.info("Process running: {}", process.toString());
        long pid = getPid(process.toString());
        cache.add(pid, process);
        LOGGER.info("Filling result");
        result.setPid(pid);
        result.setValue(buildResult(process.getInputStream()));
        return result;
    }

    /**
     * Processes an input to continue the execution.
     *
     * @param answer user input
     * @return a result value and the process id
     * @throws IOException when there is a execution problem
     */
    public Result processAnswer(InputParameters answer) throws IOException {
        Process process = cache.getProcessById(answer.getProcessId());
        LOGGER.info("Process in use: pid={}",answer.getProcessId());
        LOGGER.info("User input={}", answer.getValue());
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(Objects.requireNonNull(process).getOutputStream()));
        writer.write(answer.getValue() + System.lineSeparator());
        writer.flush();
        LOGGER.info("Filling result");
        result.setPid(answer.getProcessId());
        result.setValue(buildResult(process.getInputStream()));
        return result;
    }

    /**
     * Builds the result value.
     *
     * @param inputStream to obtain the result
     * @return result value
     * @throws IOException of system
     */
    private String buildResult(InputStream inputStream) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder builder = new StringBuilder();
        boolean isReady;
        int count = 0;
        int MAXIMUM_WAITING_VALUE = 1000000;
        while ((isReady = reader.ready()) || count < MAXIMUM_WAITING_VALUE) {
            if (isReady) {
                builder.append((char) reader.read());
            } else {
                count++;
            }
        }
        return builder.toString();
    }

    /**
     * Obtains the process id as long.
     *
     * @param processName process name
     * @return a process id
     */
    private Long getPid(String processName) {
        return Long.parseLong(
                processName.substring(
                        processName.indexOf("=") + 1, processName.indexOf(",")
                ));
    }
}
