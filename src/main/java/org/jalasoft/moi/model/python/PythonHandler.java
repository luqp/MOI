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
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Handles the flow of the execution.
 *
 * @version    1.0
 * @author     Lucero Quiroga Perez
 */
public class PythonHandler implements IHandler {

    private static final String FILE_RELATIVE_PATH = "C:/Users/Admin/Documents/temp/";
    private static final String PYTHON_EXTENSION = ".py";

    /**
     * Receives the parameters and execute the program in the file.
     *
     * @param params contains files location and language
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

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a Params
     * object for PYTHON.
     *
     * @param jsonRequest A JSON containing the parameters.
     * @return A Params object with the params needed for compile.
     */
    public Params convertToParams(String jsonRequest) throws IOException, ParseException {
        //Parses the object into different strings containing the parameters.
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonRequest);
        String fileName = (String) jsonObject.get("fileName");
        String code = (String) jsonObject.get("code");
        String version = (String) jsonObject.get("version");

        //Creates and writes a file with the code needed.
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + PYTHON_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + PYTHON_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.PYTHON_32);
        return codeParams;
    }
}
