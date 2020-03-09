/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model;

import java.io.File;
import java.io.IOException;

public class Csharp implements ILanguage {

    private static final String COMPILER_PATH = "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe";
    private static final String OPEN_CMD = "cmd.exe /c ";
    private static final String SPACE = " ";
    private static final String EXEC_COMMAND = "\"";
    private static final String CHANGE_DIRECTORY = "cd ";

    private String getFolderPath(org.jalasoft.moi.model.Params params) {
        File folder = new File(params.getFilesPath().toString());
        if (folder.exists()) {
            return OPEN_CMD + EXEC_COMMAND + CHANGE_DIRECTORY + folder.getParent();
        } else {
            return "Folder does not exist";
        }
    }

    private String getFileName(Params params) {
        File file = new File(params.getFilesPath().toString());
        if (file.exists()) {
            return SPACE + file.getName();
        } else {
            return "File does not exist";
        }
    }

    private String getCompiledName(Params params) {
        File file = new File(params.getFilesPath().toString().replace(".cs", ".exe"));
        if (file.exists()) {
            return file.getName() + EXEC_COMMAND;
        } else {
            return "File does not exist";
        }
    }

    @Override
    public String commandBuilder(Params params) {
        return getFolderPath(params) + " && " + COMPILER_PATH + getFileName(params) + " && " + getCompiledName(params);
    }

    /*public String commandBuilderHarcode() {
        return "cmd /c start cmd.exe /k \"cd C:/Users/Admin/Desktop/csharp && C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe hiworld.cs && hiworld.exe\"";
    }

    public void executeCommand(Params params) {
        try {
            Runtime.getRuntime().exec(commandBuilder(params));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can not complile the file");
        }
    }*/

}
