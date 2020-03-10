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
 * This interface defines the type of object for the classes that implement it will use
 *
 * @version 1.0
 * @author Carlos Meneses
 */
public interface ICommandBuilder {

    /**
     * This method is used to buil a command for every language that implements this interface
     * @param path contains the location of the directory or file
     * @return String of the command builded with the path Params
     */
    String buildCommand(Path path);
}
