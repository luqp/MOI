/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.core;

import java.nio.file.Path;
import java.util.List;

/**
 * Implemented for all class that want to build commands for a certain language.
 *
 * @author Lucero Quiroga Perez
 * @version 1.0
 */
public interface ICommandBuilder {

    /**
     * Builds a command given the location of the directory or file.
     *
     * @param path file location
     * @return String
     */
    String buildCommand(Path path);

    /**
     * The method builds the command for a list of files.
     *
     * @param paths list of files
     * @return The string with the correct command for execute
     */
    String buildCommand(List<Path> paths);

    /**
     * This method will be used in order to add the command to execute the compiled file.
     * @param path
     * @return The string with the correct command for execute the compiled file
     */
    String commandToRun(Path path);

    /**
     * This method will create a compile of an specific folder
     * @param path
     * @return the command for compile the folder
     */
    String buildCommandFolder(Path path);
}
