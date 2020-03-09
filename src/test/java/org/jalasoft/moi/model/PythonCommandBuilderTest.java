package org.jalasoft.moi.model;


import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonCommandBuilderTest {

    @Test
    public void builderCommandCompileTest() {
        String expected = "\\thirdparty\\python\\win\\Python37\\python.exe -m compileall \\thirdparty\\python\\local\\hello.py && \\thirdparty\\python\\win\\Python37\\python.exe \\thirdparty\\python\\local\\__pycache__\\hello.cpython-37.pyc";
        Params params = new Params();
        params.setFilesPath(Paths.get("\\thirdparty\\python\\local\\hello.py"));
        params.setLanguage(Language.PYTHON_37);
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();

        String command = pythonCommandBuilder.buildCommand(params.getFilesPath());

        assertEquals(expected, command);
    }
}
