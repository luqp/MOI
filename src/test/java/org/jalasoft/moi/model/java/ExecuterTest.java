/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;

import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.jalasoft.moi.model.interaction.ProcessCacheTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExecuterTest {
    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @Test
    public void givenTestParamAndHandlerWhenExecuteParamThenReceiveTheExpectedOutput() throws CommandBuildException, ResultException {
        //given
        String expectedResult = "Microsoft Windows [Versión 10.0.18363.720]";
        Result currentResult;
        Executer testExecute = new Executer(processCache);
        //when
        currentResult = testExecute.execute("VER");
        //then
        assertEquals(expectedResult, currentResult.getValue());
    }

    @Test
    public void throwsExceptionWhenCommandNullTest() {
        Executer executer = new Executer(new ProcessCache());
        Exception exception = assertThrows(CommandBuildException.class, () -> {
            executer.execute(null);;
        });

        String expected = "Command built was not correct.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}
