package org.jalasoft.moi.model;


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
        String python = "\\thirdparty\\python\\win\\python32\\Portable Python 3.2.5.1\\App\\python.exe";
        String compileall = " -m compileall ";
        directoryFile = "\\thirdparty\\python\\local\\";
        String concatenate = " && ";

        command = python + compileall + directoryFile + "test1.py" + concatenate + python + directoryFile + "__pycache__\\test1.cpython-37.pyc";
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

    @ParameterizedTest
    @CsvSource({
            "'Hello World', test1.py",
            "'Hello World\nHello Team\nHello you', test2"
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
