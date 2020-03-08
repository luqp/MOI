package org.jalasoft.moi.model;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PythonCommandBuilderTest {

    @Test
    public void builderCommandCompileTest() {
        Params params = new Params(Paths.get("H:/hello.py"), "3.7", Laguage.PYTHON);
        Python python = new Python(params);

        assertEquals("python -m compileall H:\\hello.py && python H:\\__pycache__\\hello.cpython-37.pyc", python.commandBuilder(params));
    }
}
