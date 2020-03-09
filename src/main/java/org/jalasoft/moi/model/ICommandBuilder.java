/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model;

import java.nio.file.Path;

/**
 * Implemented for all class that want to build commands for a certain language.
 */
public interface ICommandBuilder {

    /**
     * @param path contains the location of the directory or file.
     * @return a String that represent the commands to be executed.
     */
    String buildCommand(Path path);
}
