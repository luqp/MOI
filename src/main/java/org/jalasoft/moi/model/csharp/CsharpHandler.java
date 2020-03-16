/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handler is in charge to work with the executer and the command builder
 *
 * @author Carlos Meneses
 * @version 1.0
 */
public class CsharpHandler implements IHandler {

    /**
     * Create a builder witch build the c# command and then sends it command to
     * executer to get a result
     *
     * @param params contains the parameters to build a command a execute it
     * @return a String of result from CommandBuilder and Executer handling
     */
    @Override
    public String execute(Params params) {
        CsharpCommandBuilder cSharpCommandBuilder = new CsharpCommandBuilder();
        String command = cSharpCommandBuilder.buildCommand(params.getFilesPath());
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
