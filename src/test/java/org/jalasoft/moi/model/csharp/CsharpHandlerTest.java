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
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CsharpHandlerTest {
    @Test
    public void whenHandlerReceiveParamsBuildCommandAndExecuteThenRun(){
        //given
        String expectedResult = "Hi World";
        Params params = new Params(Paths.get("C:/Users/Admin/Desktop/csharp/hiworld.cs"), "4.0", Language.CSHARP);
        CsharpCommandBuilder compliler = new CsharpCommandBuilder();
        //when
        CsharpHandler csharpHandler = new CsharpHandler();
        String currentResult = csharpHandler.execute(params);
        //then
        assertEquals(expectedResult, currentResult);
    }

}
