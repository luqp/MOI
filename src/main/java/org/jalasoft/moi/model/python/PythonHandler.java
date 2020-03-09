/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.python;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Params;

import java.io.IOException;

/**
 * Handles the flow of the execution.
 *
 * @version    1.0
 * @author     Lucero Quiroga Perez
 */
public class PythonHandler {
    /**
     * Receives the parameters and execute the program in the file.
     *
     * @param params
     * @return String
     */
    public String execute(Params params) {
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();
        String command = pythonCommandBuilder.buildCommand(params.getFilesPath());

        Executer executer = new Executer(command);
        String result;
        try {
            result = executer.run();
        } catch (IOException e) {
            e.printStackTrace();
            result = "Nothing for compile";
        }
        return result;
    }
}
