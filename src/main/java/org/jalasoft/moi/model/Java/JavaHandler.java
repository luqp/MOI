/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.Java;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Params;

import java.io.IOException;

/**
 * Asks command builder to build a command and asks Executer to run the command
 *
 * @version 1.0 03 March 2020
 * @author Mauricio Oroza
 *
 */
public class JavaHandler implements IHandler {

    /**
     * Creates a java builder, builds a cmd command, runs command
     *
     * @param javaParams hast the java program main path
     * @return A string containing the output of the executed command
     */
    @Override
    public String execute(Params javaParams) {
        String output;
        JavaCommandBuilder newJavaCommBuild = new JavaCommandBuilder();
        String command = newJavaCommBuild.buildCommand(javaParams.getFilesPath());
        Executer taskJava = new Executer(command);
        try {
            output = taskJava.run();
        } catch (IOException e) {
            e.printStackTrace();
            output = "Exception ocurred";
        }
        return output;
    }
}
