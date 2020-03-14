/**
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

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File service is used to manage actions that each file will need as save file or show responses.
 */
@Service
public class CppFileService {

    private static final String FILE_RELATIVE_PATH = ".\\temp\\cpluplus\\";
    private static final String CPLUSPLUS_EXTENSION = ".cc";

    /**
     * SaveFile create a new file with name, extension and path, then create a object params to set the file.
     * properties in this new params object.
     *
     * @return A Params setted object.
     */
    public Params saveFile(String version, String fileName, String code) throws IOException{
        File codeFile = new File(FILE_RELATIVE_PATH + fileName + CPLUSPLUS_EXTENSION);
        FileWriter codeWriter = new FileWriter(FILE_RELATIVE_PATH + fileName + CPLUSPLUS_EXTENSION);
        codeWriter.write(code);
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(Language.CPP);
        return codeParams;
    }

    /**
     * ShowResponse receives a Params Object and uses Ihandler to return a output an show it.
     *
     * @param outPut is the object params that will be needed to use execute for handler.
     * @return is a string that will be show as an output.
     */
    public String showResponse(Params outPut) {
        IHandler handler = new CsharpHandler();
        return handler.execute(outPut);
    }


}
