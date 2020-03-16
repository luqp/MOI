package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.Main;
import org.jalasoft.moi.model.core.Params;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.nio.file.Path;

public class mainmau {

    public static void main(String[] args) {

        String carpeta = "C:\\Users\\m-a-u\\Documents\\Jala\\Git\\Pruebas cmd csharp";
        File codeFile = new File(carpeta);
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        CsharpCommandBuilder asdf = new CsharpCommandBuilder();
        String out = asdf.buildCommand(codeParams.getFilesPath());
        System.out.println(out);


    }


}
