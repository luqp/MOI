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
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
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
public class CppHandler implements IHandler {

    private static final String FILE_RELATIVE_PATH = "./temp/cplusplus/";
    private static final String CPP_EXTENSION = ".cc";

    /**
     * @param params contains the parameters to build a command a execute it
     * @return a String of result from CommandBuilder and Executer handling
     */
    @Override
    public String execute(Params params) {
        ICommandBuilder cpp = new CppCommandBuilder();
        String command = cpp.buildCommand(params.getFilesPath());
        System.out.println(command);
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

    @Override
    public Params convertToParams(String jsonRequest) throws IOException, ParseException {
        //Parses the object into different strings containing the parameters.
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonRequest);
        String fileName = (String) jsonObject.get("fileName");
        String code = (String) jsonObject.get("code");
        String version = (String) jsonObject.get("version");

        //Creates and writes a file with the code needed.
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + CPP_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + CPP_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.CPP);
        return codeParams;
    }
}
