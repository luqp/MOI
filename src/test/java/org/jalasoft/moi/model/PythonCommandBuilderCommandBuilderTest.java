package org.jalasoft.moi.model;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PythonCommandBuilderCommandBuilderTest {

    @Test
    public void builderCommandCompileTest() {
        Params params = new Params(Paths.get("\\thirdparty\\python\\local\\hello.py"), Language.PYTHON_37);
        ICommandBuilder pythonCommandBuilder = params.getLanguage().getCommandBuilder();

        String command = pythonCommandBuilder.buildCommand(params.getFilesPath());

        assertEquals("\\thirdparty\\python\\win\\Python37\\python.exe -m compileall \\thirdparty\\python\\local\\hello.py && \\thirdparty\\python\\win\\Python37\\python.exe \\thirdparty\\python\\local\\__pycache__\\hello.cpython-37.pyc", command);
    }
}
