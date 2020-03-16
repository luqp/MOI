package org.jalasoft.moi.model.python;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Builds commands to execute a python file.
 *
 * @version    1.0
 * @author     Lucero Quiroga Perez
 */
public class PythonCommandBuilder implements ICommandBuilder {

    private static final String SPACE = " ";

    private final Path pythonPath;
    private final String version;

    /**
     * @param pythonPath the location for the python file.
     * @param version language version, required to locate the .pyc file.
     */
    public PythonCommandBuilder(Path pythonPath, String version) {
        this.pythonPath = pythonPath;
        this.version = version;
    }

    /**
     * Builds compilation and execution commands.
     *
     * @param path location of the directory or file.
     * @return compilation and execution commands.
     */
    @Override
    public String buildCommand(Path path) {
        return commandToCompile() + SPACE + path + " && " + commandToRun(path);
    }

    /**
     *
     * @param paths list of files to run
     * @return command to compile more than one file
     */
    @Override
    public String buildCommand(List<Path> paths) {
        String command = commandToCompile();
        for (Path path: paths) {
            command = command + SPACE + path;
        }
        return command;
    }

    @Override
    public String buildCommandFolder(Path path) {
        return commandToCompile() + SPACE + path;
    }

    /**
     * Builds compilation command.
     *
     * @return compilation command.
     */
    private String commandToCompile() {
        return pythonPath + SPACE + "-m compileall";
    }

    /**
     * Builds execution command.
     *
     * @param path location of the directory or file.
     * @return execution command.
     */
    public String commandToRun(Path path) {
        return pythonPath + SPACE + path.toString();
    }
}
