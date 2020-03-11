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
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.cplusplus.CppHandler;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CppHandlerTest {

    @Test
    public void cppHandlerTest() {
        //given
        Params params = getParams("C:\\AWT5\\MOI\\resources\\files\\test.cpp");
        String expectedResult = "Hello, World!\n";
        //when
        IHandler cpphabdler = new CppHandler();
        String actualValue = cpphabdler.execute(params);
        //then
        assertEquals(expectedResult, actualValue);
    }

    @Test
    public void cppHandlerTestEmptyPath() {
        //given
        Params params = getParams("");
        String expectedResult = "There has not been produced any output";
        //when
        IHandler cpphabdler = new CppHandler();
        String actualValue = cpphabdler.execute(params);
        //then
        assertEquals(expectedResult, actualValue);
    }

    private Params getParams(String paramTest) {
        Params params = new Params();
        params.setFilesPath(Paths.get(paramTest));
        params.setLanguage(Language.CPP);
        return params;
    }
}
