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
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.InputParametersException;
import org.jalasoft.moi.model.exceptions.ResultException;

import javax.validation.constraints.Null;
import java.io.BufferedWriter;
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
 * @version 1.1 03 March 2020
 */
public class Executer {

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
    public Result execute(String command) throws CommandBuildException, ResultException {
        String builtCommand = "cmd /c \"" + command + "\"";
        Process tempProcess;
        long pid;
        try {
            tempProcess = Runtime.getRuntime().exec(builtCommand);
            pid = getPid(tempProcess.toString());
        } catch (IOException | StringIndexOutOfBoundsException e) {
            throw new CommandBuildException(e);
        }
        cache.add(pid, tempProcess);
        result.setPid(pid);
        try {
            result.setValue(buildResult(tempProcess));
        } catch (IOException e) {
            throw new ResultException(result, e);
        }
        return result;
    }

    /**
     * Processes an input to continue the execution.
     *
     * @param answer user input
     * @return a result value and the process id
     * @throws IOException when there is a execution problem
     */
    public Result processAnswer(InputParameters answer) throws InputParametersException, ResultException {
        Process process;
        try {
            process = cache.getProcessById(answer.getProcessId());
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(Objects.requireNonNull(process).getOutputStream()));
            writer.write(answer.getValue() + System.lineSeparator());
            writer.flush();
        } catch (IOException | NullPointerException e) {
            throw new InputParametersException(e);
        }

        try {
            result.setPid(answer.getProcessId());
            result.setValue(buildResult(process));
        } catch (IOException e) {
            throw new ResultException(result, e);
        }
        return result;
    }

    /**
     * Builds the result value.
     *
     * @param process to obtain the result
     * @return result value
     * @throws IOException of system
     */
    private String buildResult(Process process) throws IOException {
        InputStream inputStream = process.getInputStream();
        InputStreamReader cmdEntrance = new InputStreamReader(inputStream);
        int count = 0;
        while (!cmdEntrance.ready()) {
            if (count >= Integer.MAX_VALUE) {
                cache.deleteProcess(getPid(process.toString()));
                return "Code was not Executed";
            }
            count++;
        }
        char[] charBuffer = new char[inputStream.available()];
        cmdEntrance.read(charBuffer);
        return new String(charBuffer);
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
