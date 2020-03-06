/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.csharpcompiler;

import java.io.File;
import java.io.IOException;

public class CsharpCompliler {

    String cSharpPath;

    public CsharpCompliler() {
        cSharpPath = "C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\csc.exe";
    }

    public File getFile() {
        String sRuote = "C:\\Users\\Admin\\IdeaProjects\\com\\csharp\\hiworld.cs";
        File route = new File(sRuote);
        return route;
    }

    public String printComplilePath() {
        if (getFile().exists()) {
            String fileName = getFile().getName();
            return cSharpPath + " " + fileName;
        } else {
            return "El fichero no existe";
        }
    }

    public String printFilePath() {
        if (getFile().getParent() != null) {
            return getFile().getParent();
        } else {
            return "El fichero no existe";
        }
    }

    public void executeCommand() {
        try {
            String cmdInit = "cmd /c start cmd.exe /k \" cd ";
            String command = cmdInit + printFilePath() + " && " + printComplilePath() + " && hiworld.exe\"";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can not complile the file");
        }

    }

}
