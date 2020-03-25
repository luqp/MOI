/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;

import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.ParametersException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.jalasoft.moi.model.interaction.ProcessCacheTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaHandlerTest {

    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @Test
    public void givenTestParamAndHandlerWhenExecuteParamThenReceiveTheExpectedOutput() throws ResultException, CommandBuildException, ParametersException {
        //given
        String expectedResult = "Hey! estoy en el main1!/nhellooooooooo!!!!/nHey! estoy en el main2!";
        Result currentResult;
        Parameters testParam = new Params();
        testParam.setFilesPath(Paths.get(".\\temp\\java\\test\\single.java"));
        testParam.setLanguage(Language.JAVA);
        Handler JH = new Handler(processCache);
        //when
        currentResult = JH.runProgram(testParam);
        //then
        assertEquals(expectedResult, currentResult.getValue());
    }

}
