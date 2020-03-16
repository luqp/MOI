/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.cplusplus;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Params;
import java.io.IOException;

/**
 * Handler is in charge to work with the executer and the command builder
 *
 * @author Carlos Camacho
 *         Diego Perez
 * @version 1.1
 */
public class CppHandler implements IHandler {

    /**
     * @param params contains the parameters to build a command and execute it
     * @return a String of result from CommandBuilder and Executer handling.
     */
    @Override
    public String execute(Params params) {
        ICommandBuilder cpp = new CppCommandBuilder();
        String command = cpp.buildCommand(params.getFilesPath());
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
