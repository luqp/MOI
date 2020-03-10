/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class defines the functions for the communication between the
 * controller and the model.
 *
 * @version        1.0
 * @author         Diego Perez
 */
public class CodeHelper {

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a
     * Params object.
     *
     * @param jsonRequest A JSON containing the parameters.
     * @return A Params object with the params needed for compile.
     * @throws IOException
     * @throws ParseException
     */
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
        Params codeParams = new Params(codeFile.toPath(), version, Language.JAVA);
        return codeParams;
    }

    /**
     * Returns the output from the execution of the code sent.
     * @param codeParams Parameters of a code project.
     * @return A String containing the output of the execution.
     */
    public String execCode(Params codeParams) {
        //TO DO
        //Change the functionality to that of showing the output of an execution.
        return "Worked " + codeParams.getFilesPath().toFile().getName();
    }
}
