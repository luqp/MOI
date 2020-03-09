/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model;

import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class CsharpCommandBuilderTest {
    @Test
    public void givenParamsWhenBuildCommandThenReceiveTheExpectedComand(){
        //given
        Params params = new Params(Paths.get("C:/Users/Admin/Desktop/csharp/hiworld.cs"), "4.0", Language.CSHARP);
        CsharpCommandBuilder compliler = new CsharpCommandBuilder();
        String expectedCommand = "cd C:\\Users\\Admin\\Desktop\\csharp && C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe hiworld.cs && hiworld.exe";
        //when
        String currentCommand = compliler.commandBuilder(params.getFilesPath());
        //then

        /*Params params = new Params(Paths.get("C:/Users/Admin/Desktop/csharp/hiworld.cs"), "4.0", Language.CSHARP);
        CsharpCommandBuilder compliler = new CsharpCommandBuilder();
        System.out.println(compliler.commandBuilder(params.getFilesPath()));
        String expectedCommand = "cd C:\\Users\\Admin\\Desktop\\csharp && C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe hiworld.cs && hiworld.exe";
        System.out.println(expectedCommand);*/

    }
}
