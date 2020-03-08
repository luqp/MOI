package org.jalasoft.moi.model;

import java.nio.file.Paths;

public class Python {

    private static String PYTHON = "python";
    private static String SPACE = " ";
    private final Params params;

    public Python(Params params) {
        this.params = params;
    }

    public String buildCommandToCompile() {
        String COMPILE_ALL = "-m compileall";
        return PYTHON + SPACE + COMPILE_ALL + SPACE + params.getFilesPath().toString();
    }

    public String buildCommandToRun() {
        String fileName = params.getFilesPath().getFileName().toString().replace(".py", "");
        return PYTHON + SPACE + Paths.get(params.getFilesPath().getRoot() + "__pycache__/" + fileName + ".cpython-37.pyc");
    }
}
