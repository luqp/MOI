/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.csharp;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;
import java.util.List;

/**
 * Builds a command for c# files compilation and execution
 * using the path provided by Params object.
 *
 * @author Carlos Meneses
 *         Mauricio Oroza
 * @version 1.1
 */
public class CsharpCommandBuilder implements ICommandBuilder {

    private static final String COMPILER_PATH = "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe ";
    private static final String COMPILE_ALL_AND_OUTPUT = "-optimize -out:Output.exe *.cs";
    private static final String RUN_OUTPUT = "Output";
    private static final String MOVE_TO = "cd ";

    /**
     * Builds a string with the command needed for compilation and execution of multiple files.
     *
     * @path completePath contains the location of the directory of the files
     * @return String of the command builded with the path received
     */
    @Override
    public String buildCommand(Path completePath) {
        return MOVE_TO + completePath.toString() + " && " + COMPILER_PATH + COMPILE_ALL_AND_OUTPUT + " && " + RUN_OUTPUT;
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
