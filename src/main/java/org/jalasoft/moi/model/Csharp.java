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

public class Csharp {

    private String COMPLILER_PATH = "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe";
    private String OPEN_CMD = "cmd /c start cmd.exe /k \"";
    private String FOLDER_PATH = "cd C:/Users/Admin/IdeaProjects/com/csharp";

    public Csharp() {
    }

    public String getFileName() {
        File file = new File("C:/Users/Admin/IdeaProjects/com/csharp/hiworld.cs");
        if (file.exists()) {
            return " " + file.getName();
        } else {
            return "File does not exist";
        }
    }
    public String getFileGeneradedName() {
        File file = new File("C:/Users/Admin/IdeaProjects/com/csharp/hiworld.exe");
        if (file.exists()) {
            return file.getName()+"\"";
        } else {
            return "File does not exist";
        }
    }

    public String commandBuilder() {
        return OPEN_CMD + FOLDER_PATH + " && " + COMPLILER_PATH + getFileName()+" && "+ getFileGeneradedName();
    }

    public String commandBuilderHarcode() {
        return "cmd /c start cmd.exe /k \"cd C:/Users/Admin/IdeaProjects/com/csharp && C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe hiworld.cs && hiworld.exe\"";
    }

    public void executeCommand() {
        try {

            Runtime.getRuntime().exec(commandBuilder());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can not complile the file");
        }

    }

}
