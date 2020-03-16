/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import jdk.nashorn.internal.runtime.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class recieves a string, executes it on cmd and returns output on a string
 *
 * @author Mauricio Oroza
 * @version 1.0 03 March 2020
 */
public class Executer {

    private String command;

    /**
     * Constructor receives string command
     *
     * @param command command to be executed
     */
    public Executer(String command) {
        String commandSlash = "\"";
        this.command = "cmd /c " + commandSlash + command + commandSlash;
    }

    /**
     * Executes command in cmd
     *
     * @return The output of the console in one string in the form: String1 + \n + String1 + \n + ...
     */
    public String run() throws IOException, InterruptedException {
        StringBuilder builder = new StringBuilder();
        Process tempProcess = Runtime.getRuntime().exec(command);
        InputStream inputStream = tempProcess.getInputStream();
        InputStreamReader cmdEntrance = new InputStreamReader(inputStream);
        while (!cmdEntrance.ready()) {}
        char[] charBuffer = new char[inputStream.available()];
        cmdEntrance.read(charBuffer);
        return new String(charBuffer);
    }
}
