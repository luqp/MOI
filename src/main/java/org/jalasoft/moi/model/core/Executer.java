/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class recieves a string, executes it on cmd and returns output on a string
 *
 * @version 1.0 03 March 2020
 * @author Mauricio Oroza
 *
 */
public class Executer {

    private String command;
    private String output;

    /**
     * Constructor recieves string command
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
    public String run() throws IOException {
        StringBuilder builder = new StringBuilder();
        Process tempProcess = Runtime.getRuntime().exec(command);
        InputStreamReader cmdEntrance = new InputStreamReader(tempProcess.getInputStream());
        BufferedReader stdInput = new BufferedReader(cmdEntrance);
        if ((output = stdInput.readLine()) != null) {
            builder.append(output).append("\n");
            while ((output = stdInput.readLine()) != null) {
                builder.append(output).append("\n");
            }
            output = builder.toString();
        } else {
            output = "There has not been produced any output";
        }
        return output;
    }
}
