/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.cpp;

import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.interaction.ProcessCacheTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CppHandlerTest {

    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @Test
    public void cppHandlerTest() {
        //given
        Parameters params = getParams(".\\temp\\cplusplus\\test\\test.cpp");
        String expectedResult = "Hello, World!\n";
        //when
        Handler cppHandler = new Handler(processCache);
        Result actualValue = cppHandler.runProgram(params);
        //then
        assertEquals(expectedResult, actualValue.getValue());
    }

    @Test
    public void cppHandlerTestEmptyPath() {
        //given
        Params params = getParams("");
        String expectedResult = "There has not been produced any output";
        //when
        Handler cppHandler = new Handler(processCache);
        Result actualValue = cppHandler.runProgram(params);
        //then
        assertEquals(expectedResult, actualValue.getValue());
    }

    private Params getParams(String paramTest) {
        Params params = new Params();
        params.setFilesPath(Paths.get(paramTest));
        params.setLanguage(Language.CPP);
        return params;
    }
}
