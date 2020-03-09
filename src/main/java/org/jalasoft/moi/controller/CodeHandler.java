/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import org.jalasoft.moi.model.Language;
import org.jalasoft.moi.model.Params;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CodeHandler {

    public Params codeParams(String fileName, String code, String language, String version) {
        Params codeParams = null;
        File codeFile = new File("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
        try {
            FileWriter codeWriter = new FileWriter("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
            codeWriter.write(code);
            codeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (language) {
            case "python" :
                codeParams = new Params(Path.of(codeFile.getAbsolutePath()), version, Language.PYTHON);
        }
        return codeParams;
    }

    public String execCode(Params codeParams) {

        return "";
    }
}
