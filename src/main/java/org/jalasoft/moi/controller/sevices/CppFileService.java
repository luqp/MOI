/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.sevices;

import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.csharp.CsharpHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class CppFileService {

    private static final String FILE_RELATIVE_PATH = ".\\temp\\cpluplus\\";
    private static final String CPLUSPLUS_EXTENSION = ".cc";

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a
     * Params object.
     *
     * @param jsonRequest A string ready to be decomposed into variables.
     * @return A Params object.
     */
    public Params convertToParams(String jsonRequest) throws IOException, ParseException {
        //Parses the object into different strings containing the parameters.
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonRequest);
        String fileName = (String) jsonObject.get("fileName");
        String code = (String) jsonObject.get("code");
        String version = (String) jsonObject.get("version");

        //Creates and writes a file with the code needed.
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + CPLUSPLUS_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + CPLUSPLUS_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.CPP);
        return codeParams;
    }

    public String handlerExecute(Params outPut) {
        IHandler handler = new CsharpHandler();
        return handler.execute(outPut);
    }


}
