/**
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.python.PythonHandler;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File service is used to manage actions that each file will need as save file or show responses.
 *
 * @author Carlos Meneses.
 * @version 1.1
 */
@Service
public class PythonFileService {

    private static final String FILE_RELATIVE_PATH = ".\\temp\\python\\";
    private static final String PYTHON_EXTENSION = ".py";

    /**
     * SaveFile create a new file with name, extension and path to set the file properties in this new params object.
     *
     * @return A Params setted object.
     */
    public Params saveFile(String version, String fileName, String code) throws IOException{
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + PYTHON_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + PYTHON_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.PYTHON_32);
        return codeParams;
    }

    /**
     * ShowResponse receives a Params Object and uses Ihandler to return a output an show it.
     *
     * @param outPut is the object params that will be needed to use execute for handler.
     * @return is a string that will be show as an output.
     */
    public String showResponse(Params outPut) {
        IHandler handler = new PythonHandler();
        return handler.execute(outPut);
    }


}
