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

    private String C_SHARP_PATH = "C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\csc.exe";
    private File file;

    /**
     * @param sRoute add the file path to create a new file
     */
    public CsharpCompliler(String sRoute) {
        file = new File(sRoute);
    }

    private String printComplilePath() {
        if (file.exists()) {
            String fileName = file.getName();
            return C_SHARP_PATH + " " + fileName;
        } else {
            return "El fichero no existe";
        }
    }

    private String printFilePath() {
        if (file.getParent() != null) {
            return file.getParent();
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
