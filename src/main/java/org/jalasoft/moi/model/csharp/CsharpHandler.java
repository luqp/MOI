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
 * @version 1.0
 * @author Carlos Meneses
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

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a
     * Params for CSHARP.
     *
     * @param jsonRequest A JSON containing the parameters.
     * @return A Params object with the params needed for compile.
     */
    @Override
    public Params codeParams(String jsonRequest) throws IOException, ParseException {
        //Parses the object into different strings containing the parameters.
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonRequest);
        String fileName = (String) jsonObject.get("fileName");
        String code = (String) jsonObject.get("code");
        String language = (String) jsonObject.get("language");
        String version = (String) jsonObject.get("version");
        //Creates and writes a file with the code needed.
        File codeFile = new File("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
        FileWriter codeWriter = new FileWriter("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params(codeFile.toPath(),
                                        version,
                                        Language.CSHARP);
        return codeParams;
    }
}
