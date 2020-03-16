/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;
import java.util.List;

/**
 * Builds a command and execute a c# file using the path provided by Params object
 * and uses the complete path of c# in window to build its string
 *
 * @author Carlos Meneses
 * @version 1.0
 */
public class CsharpCommandBuilder implements ICommandBuilder {

    private static final String COMPILER_PATH = "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe ";
    private static final String CHANGE_DIRECTORY = "cd ";

    /**
     * @param path contains the location of the directory or file
     * @return String of the directory to change
     */
    private String getFolderPath(Path path) {
        return CHANGE_DIRECTORY + path.getParent().toString();
    }

    /**
     * @param path contains the location of the directory or file
     * @return String of the compiled file name
     */
    private String getCompiledName(Path path) {
        return path.getFileName().toString().replace(".cs", ".exe");
    }

    /**
     * @param path contains the location of the directory or file
     * @return String of the command builded with the path Params
     */
    @Override
    public String buildCommand(Path path) {
        return getFolderPath(path)+" && "+COMPILER_PATH+path.getFileName().toString()+" && "+getCompiledName(path);
    }

    @Override
    public String buildCommand(List<Path> paths) {
        return null;
    }

    @Override
    public String commandToRun(Path path) {
        return null;
    }

    @Override
    public String buildCommandFolder(Path path) {
        return null;
    }

}
