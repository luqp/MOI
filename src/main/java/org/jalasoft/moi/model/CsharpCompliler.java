package org.jalasoft.moi.model;

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

    public String printCommand() {
        if (getFile().exists()) {
            String filePath= getFile().getParent();
            String fileName= getFile().getName();
            return filePath +">"+ cSharpPath + " "+ fileName;
        } else {
            return "El fichero no existe";
        }
    }

    public void executeCommand(){
        try {
            String command = "C:\\Users\\Admin\\IdeaProjects\\com\\csharp>C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\csc.exe hiworld.cs";
            Runtime.getRuntime().exec(command);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Can not complile the file");
        }

    }

}
