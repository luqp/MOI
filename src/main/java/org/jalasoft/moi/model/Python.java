package org.jalasoft.moi.model;

import java.nio.file.Paths;

public class Python implements ILanguage{

    private static final String PYTHON = "python";
    private static final String SPACE = " ";

    private String buildCommandToCompile(Params params) {
        String COMPILE_ALL = "-m compileall";
        return PYTHON + SPACE + COMPILE_ALL + SPACE + params.getFilesPath().toString();
    }

    private String buildCommandToRun(Params params) {
        String fileName = params.getFilesPath().getFileName().toString().replace(".py", "");
        return PYTHON + SPACE + Paths.get(params.getFilesPath().getRoot() + "__pycache__/" + fileName + ".cpython-37.pyc");
    }

    @Override
    public String commandBuilder(Params params) {
        return buildCommandToCompile(params) + " && " + buildCommandToRun(params);
    }
}
