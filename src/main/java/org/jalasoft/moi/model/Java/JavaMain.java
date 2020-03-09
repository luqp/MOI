/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 *
 */

package org.jalasoft.moi.model.Java;

import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;

import java.nio.file.Paths;

public class JavaMain {

    public static void main(String[] arg){
        //given
        Params params = new Params(Paths.get("C:/Users/MauricioOroza/com/MainClass"), "1.8", Language.JAVA);
        JavaCommandBuilder buildJavaCommand = new JavaCommandBuilder();
        System.out.println(buildJavaCommand.commandBuilder(params.getFilesPath()));
        String expectedCommand = "cd C:/Users/MauricioOroza/com && javac *.java && java MainClass";
        System.out.println(expectedCommand);
        //when
        //String currentCommand = buildJavaCommand.commandBuilder(testParam.getFilesPath());
        //System.out.println(currentCommand);
        //System.out.println(expectedCommand);
        //String comm1="cmd /c \"cd C:/Users/MauricioOroza/com && javac *.java && java MainClass\"";
    }
}
