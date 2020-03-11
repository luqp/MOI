/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.cpp;

import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.cplusplus.CppCommandBuilder;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CppCommandBuilderTest {

    @Test
    public void cppCommandBuilderTest() {
        //given
        Params params = getParams("C:\\AWT5\\MOI\\resources\\files\\test.cpp");
        ICommandBuilder cppCompliler = new CppCommandBuilder();
        String expectedCommand = " cd C:\\MinGW\\bin\\ && c++.exe C:\\AWT5\\MOI\\resources\\files\\test.cpp -o C:\\AWT5\\MOI\\resources\\files\\test.exe && cd C:\\AWT5\\MOI && C:\\AWT5\\MOI\\resources\\files\\test.exe";
        //when
        String currentCommand = cppCompliler.buildCommand(params.getFilesPath());
        //then
        assertEquals(expectedCommand, currentCommand);
    }

    private Params getParams(String paramTest) {
        Params params = new Params();
        params.setFilesPath(Paths.get(paramTest));
        params.setLanguage(Language.CPP);
        return params;
    }
}
