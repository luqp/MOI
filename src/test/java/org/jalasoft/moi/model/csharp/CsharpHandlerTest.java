/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.csharp;


import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.ParametersException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.jalasoft.moi.model.interaction.ProcessCacheTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CsharpHandlerTest {

    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @Test
    public void whenHandlerReceiveParamsBuildCommandAndExecuteThenRun() throws ResultException, CommandBuildException, ParametersException {
        //given
        String expectedResult = "Hello World1\nFile 2!!!\nHello World2";
        Parameters params = new Params();
        params.setLanguage(Language.CSHARP);
        params.setFilesPath(Paths.get(".\\thirdparty\\csharp\\Local\\"));
        //when
        Handler csharpHandler = new Handler(processCache);
        Result currentResult = csharpHandler.runProgram(params);
        //then
        assertEquals(expectedResult, currentResult.getValue());
    }
}
