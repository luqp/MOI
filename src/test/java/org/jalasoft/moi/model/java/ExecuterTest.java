/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;import org.jalasoft.moi.model.core.Executer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuterTest {
    @Test
    public void givenTestParamAndHandlerWhenExecuteParamThenReceiveTheExpectedOutput() {
        //given
        String expectedResult = "Microsoft Windows [Version 10.0.17763.678]";
        String currentResult;
        Executer testExecute = new Executer("VER");
        //when
        try {
            currentResult = testExecute.run();
        } catch (IOException | InterruptedException e) {
            currentResult = "Algo ha fallado";
            e.printStackTrace();
        }
        //then
        assertEquals(expectedResult, currentResult);
    }
}
