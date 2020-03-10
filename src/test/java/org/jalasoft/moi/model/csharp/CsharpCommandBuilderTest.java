/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsharpCommandBuilderTest {

    @Test
    public void givenPathParamsWhenBuildCommandThenReceiveTheExpectedComand(){
        //given
        Params params = new Params(Paths.get("C:/Users/Admin/Desktop/csharp/hiworld.cs"), "4.0", Language.CSHARP);
        CsharpCommandBuilder compliler = new CsharpCommandBuilder();
        String expectedCommand = "cd C:\\Users\\Admin\\Desktop\\csharp && C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe hiworld.cs && hiworld.exe";
        //when
        String currentCommand = compliler.buildCommand(params.getFilesPath());
        //then
        assertEquals(expectedCommand, currentCommand);
    }
}
