/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Params;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CsharpCommandBuilderTest {

    @Test
    public void cSharpCmdBuilderTest() {
        //given
        String carpeta = "C:\\Users\\MauricioOroza\\Pruebas cmd csharp";
        File codeFile = new File(carpeta);
        Params codeParams = new Params();
        codeParams.setFilesPath(codeFile.toPath());
        ICommandBuilder cppCommandBuilder = new CsharpCommandBuilder();
        String expectedCommand = "cd C:\\Users\\MauricioOroza\\Pruebas cmd csharp && " +
                "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe -optimize -out:Output.exe *.cs && Output";
        //when
        String currentCommand = cppCommandBuilder.buildCommand(codeParams.getFilesPath());
        //then
        assertEquals(expectedCommand, currentCommand);
    }
}
