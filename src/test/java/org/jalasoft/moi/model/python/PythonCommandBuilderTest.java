/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.python;


import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonCommandBuilderTest {

    private static String directoryFile;
    private static String command;

    @BeforeAll
    static void initAll() {
        String actualParentPath = System.getProperty("user.dir");
        String python = actualParentPath + "\\thirdparty\\python\\win\\python32\\Portable_Python_3.2.5.1\\App\\python.exe";
        String compileall = " -m compileall ";
        directoryFile = actualParentPath + "\\thirdparty\\python\\local\\";
        String concatenate = " && ";

        command = python + compileall + directoryFile + "test1.py" + concatenate + python + " " + directoryFile + "test1.py";
    }

    @Test
    public void builderCommandCompileTest() {
        Params params = new Params();
        params.setFilesPath(Paths.get(directoryFile + "test1.py"));
        params.setLanguage(Language.PYTHON_32);
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();

        String commandResult = pythonCommandBuilder.buildCommand(params.getFilesPath());

        assertEquals(command, commandResult);
    }

    @Test
    public void builderCommandCompileDirectoryTest() {
        Params params = new Params();
        params.setFilesPath(Paths.get(directoryFile));
        params.setLanguage(Language.PYTHON_32);
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();

        String commandResult = pythonCommandBuilder.buildCommand(params.getFilesPath());

        assertEquals(command, commandResult);
    }

    @ParameterizedTest
    @CsvSource({
            "'Hello World\n', test1.py",
            "'Hello World\nHello Team\nHello you\n', test2.py"
    })
    public void executeFileTest(String expect, String file) {
        Params params = new Params();
        params.setFilesPath(Paths.get(directoryFile + file));
        params.setLanguage(Language.PYTHON_32);
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();

        String commandResult = pythonCommandBuilder.buildCommand(params.getFilesPath());
        Executer executer = new Executer(commandResult);
        String result;
        try {
            result = executer.run();
        } catch (IOException e) {
            e.printStackTrace();
            result = e.getMessage();
        }

        assertEquals(expect, result);
    }
}
