/*
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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

/**
 * Class receives a string, executes it on cmd and returns output on a string
 *
 * @author Mauricio Oroza
 * @version 1.0 03 March 2020
 */
public class Executer {

    private ICacheProvider cache;
    private Result result;

    public Executer(ICacheProvider cache) {
        this.cache = cache;
        this.result = new ProcessResult();
    }

    /**
     * Executes command in cmd
     *
     * @return The output of the console in one string in the form: String1 + \n + String1 + \n + ...
     */
    public Result execute(String command) throws IOException {
        String builtCommand = "cmd /c \"" + command + "\"";
        Process tempProcess = Runtime.getRuntime().exec(builtCommand);
        long pid = getPid(tempProcess.toString());
        cache.add(pid, tempProcess);
        result.setPid(pid);
        result.setResult(buildResult(tempProcess));
        return result;
    }

    public Result processAnswer(InputParameters answer) throws IOException {
        Process process = cache.getProcessById(answer.getProcessId());
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(Objects.requireNonNull(process).getOutputStream()));
        writer.write(answer.getValue() + System.lineSeparator());
        writer.flush();

        result.setPid(answer.getProcessId());
        result.setResult(buildResult(process));
        return result;
    }

    private String buildResult(Process process) throws IOException {
        InputStream inputStream = process.getInputStream();
        InputStreamReader cmdEntrance = new InputStreamReader(inputStream);
        while (!cmdEntrance.ready()) {
        }
        char[] charBuffer = new char[inputStream.available()];
        cmdEntrance.read(charBuffer);
        return new String(charBuffer);
    }

    private Long getPid(String processName) {
        return Long.parseLong(
                processName.substring(
                        processName.indexOf("=") + 1, processName.indexOf(",")
                ));
    }
}
