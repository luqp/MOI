/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.jalasoft.moi.model.core.parameters.InputParams;

import java.io.*;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Class recieves a string, executes it on cmd and returns output on a string
 *
 * @author Mauricio Oroza
 * @version 1.0 03 March 2020
 */
public class Executer {

    private String command;
    private Result result;

    /**
     * Constructor receives string command
     *
     * @param command command to be executed
     */
    public Executer(String command) {
        String commandSlash = "\"";
        this.command = "cmd /c " + commandSlash + command + commandSlash;
        this.result = new Result();
    }

    /**
     * Executes command in cmd
     *
     * @return The output of the console in one string in the form: String1 + \n + String1 + \n + ...
     */
    public Result run() throws IOException {
        Process tempProcess = Runtime.getRuntime().exec(command);
//        loaderProcess.put(tempProcess.pid(), tempProcess);
        result.setPid(tempProcess.pid());
        result.setResult(buildResult(tempProcess));
        return result;
    }

    public Result setInput(InputParams input) throws IOException {
//        Process process = loaderProcess.getIfPresent(input.getProcessPid());
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(Objects.requireNonNull(process).getOutputStream()));
//        writer.write(input.getInput());
//        writer.close();
//        result.setPid(input.getProcessPid());
//        result.setResult(buildResult(process));
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
}
