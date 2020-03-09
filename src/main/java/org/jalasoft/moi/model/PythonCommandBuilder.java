package org.jalasoft.moi.model;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Builds commands to execute a python file.
 */
public class PythonCommandBuilder implements ICommandBuilder {

    private static final String SPACE = " ";

    private final Path pythonPath;
    private final String version;

    /**
     * @param pythonPath is the location for the python file.
     * @param version of the language, required to locate the .pyc file.
     */
    public PythonCommandBuilder(Path pythonPath, String version) {
        this.pythonPath = pythonPath;
        this.version = version;
    }

    /**
     * @param path contains the location of the directory or file.
     * @return compilation and execution commands.
     */
    @Override
    public String buildCommand(Path path) {
        return commandToCompile(path) + " && " + commandToRun(path);
    }

    /**
     * @param path contains the location of the directory or file.
     * @return compilation command.
     */
    private String commandToCompile(Path path) {
        return pythonPath + SPACE + "-m compileall" + SPACE + path;
    }

    /**
     * @param path contains the location of the directory or file.
     * @return execution command.
     */
    private String commandToRun(Path path) {
        String fileName = path.getFileName().toString().replace(".py", "");
        return pythonPath + SPACE + Paths.get(path.getParent() + "/__pycache__/" + fileName + ".cpython-" + version + ".pyc");
    }
}
