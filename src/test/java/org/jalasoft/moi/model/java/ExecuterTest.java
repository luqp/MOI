/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.parameters.ProcessResult;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.jalasoft.moi.model.interaction.ProcessCacheTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuterTest {
    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @Test
    public void givenTestParamAndHandlerWhenExecuteParamThenReceiveTheExpectedOutput() {
        //given
        String expectedResult = "Microsoft Windows [Version 10.0.17763.678]";
        Result currentResult;
        Executer testExecute = new Executer(processCache);
        //when
        try {
            currentResult = testExecute.execute("VER");
        } catch (CommandBuildException | ResultException e) {
            e.printStackTrace();
            currentResult = new ProcessResult();
            currentResult.setValue("Algo ha fallado");
            currentResult.setPid(0);
        }
        //then
        assertEquals(expectedResult, currentResult.getValue());
    }
}
