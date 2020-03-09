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

/**
 * Implemented for all class that want to build commands for a certain language.
 *
 * @version     1.0
 * @author      Lucero Quiroga Perez
 */
public interface ICommandBuilder {

    /**
     * Builds a command given the location of the directory or file.
     *
     * @param path
     * @return String.
     */
    String buildCommand(Path path);
}
