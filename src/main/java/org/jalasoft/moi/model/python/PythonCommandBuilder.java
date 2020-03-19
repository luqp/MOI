package org.jalasoft.moi.model.python;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Builds commands to execute a python file.
 *
 * @author Lucero Quiroga Perez
 * @version 1.0
 */
public class PythonCommandBuilder implements ICommandBuilder {

    private static final String SPACE = " ";

    private final Path pythonPath;

    /**
     * @param pythonPath the location for the python file.
     */
    public PythonCommandBuilder(Path pythonPath) {
        this.pythonPath = pythonPath;
    }

    /**
     * Builds compilation and execution commands.
     *
     * @param path location of the directory or file.
     * @return compilation and execution commands.
     */
    @Override
    public String buildCommand(Path path) {
        return commandToCompile(path) + " && " + commandToRun(path);
    }

    /**
     * Builds compilation command.
     *
     * @param path the location of the directory or file.
     * @return compilation command.
     */
    private String commandToCompile(Path path) {
        return pythonPath + SPACE + "-m compileall" + SPACE + path;
    }

    /**
     * Builds execution command.
     *
     * @param path location of the directory or file.
     * @return execution command.
     */
    private String commandToRun(Path path) {
        return pythonPath + SPACE + path;
    }
}
