/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 *
 */

package org.jalasoft.moi.model;

import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaCommandBuilderTest {

    @Test
    public void givenParamsWhenBuildCommandThenReceiveTheExpectedComand() {
        //given
        Params testParam = new Params();
        testParam.setFilesPath(Paths.get("C:/Users/MauricioOroza/com/MainClass"));
        testParam.setLanguage(Language.JAVA);
        ICommandBuilder buildThisCommand = testParam.getLanguage().getCommandBuilder();
        String expectedCommand = "cd C:/Users/MauricioOroza/com && javac *.java && java MainClass";
        //when
        String currentCommand = buildThisCommand.buildCommand(testParam.getFilesPath());
        //then
        assertEquals(expectedCommand, currentCommand);
    }
}
