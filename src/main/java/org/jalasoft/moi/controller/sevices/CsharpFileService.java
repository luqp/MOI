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
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class CsharpFileService {

    private static final String FILE_RELATIVE_PATH = ".\\temp\\csharp\\";
    private static final String CSHARP_EXTENSION = ".cs";

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a
     * Params object.
     *
     * @return A Params object.
     */
    public Params saveFile(String version, String fileName, String code) throws IOException, ParseException {
        //Creates and writes a file with the code needed.
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + CSHARP_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + CSHARP_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.CSHARP);
        return codeParams;
    }

    public String handlerExecute(Params outPut) {
        IHandler handler = new CsharpHandler();
        return handler.execute(outPut);
    }


}
