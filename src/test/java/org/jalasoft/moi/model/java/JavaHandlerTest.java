/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.java;

import org.jalasoft.moi.model.java.JavaHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaHandlerTest {

    @Test
    public void givenTestParamAndHandlerWhenExecuteParamThenReceiveTheExpectedOutput() {
        //given
        String expectedResult = "Hey! estoy en el main1!/nhellooooooooo!!!!/nHey! estoy en el main2!";
        String currentResult;
        Params testParam = new Params();
        testParam.setFilesPath(Paths.get("C:/Users/Admin/Documents/temp/wea"));
        testParam.setLanguage(Language.JAVA);
        JavaHandler JH = new JavaHandler();
        //when
        currentResult = JH.execute(testParam);
        //then
        assertEquals(expectedResult, currentResult);
    }

}
