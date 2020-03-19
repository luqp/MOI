/*
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.domain.FileCode;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Params;
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
public class FileService {

    /**
     * SaveFile create a new file with name, extension and path, then create a object params to set the file
     * properties in this new params object.
     *
     * @return A Params setted object.
     */
    public Parameters saveFile(String name, String code, String filePath, String extension, Language language) throws IOException {
        //Creates and writes a file with the code needed.
        File codeFile = new File(filePath + name + extension);
        FileWriter codeWriter = new FileWriter(filePath + name + extension);
        codeWriter.write(code);
        codeWriter.close();
        Parameters codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(language);
        return codeParams;
    }
    /**
     * SaveFile create a new file with name, extension and path, then create a object params to set the file
     * properties in this new params object.
     *
     * @return A Params setted object.
     */
    public Params saveFileByBody(FileCode fileCode, String filePath, String extension, Language language) throws IOException {
        //Creates and writes a file with the code needed.
        File codeFile = new File(filePath + fileCode.getName() + extension);
        FileWriter codeWriter = new FileWriter(filePath + fileCode.getName() + extension);
        codeWriter.write(fileCode.getCode());
        codeWriter.close();
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(language);
        return codeParams;
    }
}
