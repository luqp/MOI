/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;

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
 * Asks command builder to build a command and asks Executer to run the command
 *
 * @version 1.0 03 March 2020
 * @author Mauricio Oroza
 *
 */
public class JavaHandler implements IHandler {

    private static final String FILE_RELATIVE_PATH = "C:/Users/Admin/Documents/temp/";
    private static final String JAVA_EXTENSION = ".java";

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

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a Params
     * object for JAVA.
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
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + JAVA_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + JAVA_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.JAVA);
        return codeParams;
    }
}
