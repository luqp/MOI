/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;


import java.nio.file.Paths;

/**
 * Represent the supported languages and give access to the appropriate command builder.
 *
 * @version    1.0
 * @author     Lucero Quiroga Perez
 */
public enum Language {
    PYTHON_37(new PythonCommandBuilder(Paths.get("/thirdparty/python/win/Python37/python.exe"), "37"));

    private final ICommandBuilder commandBuilder;

    /**
     * Set the command builder of a specific language and version
     *
     * @param commandBuilder
     */
    Language(ICommandBuilder commandBuilder) {
        this.commandBuilder = commandBuilder;
    }

    /**
     * Contains the command builder specific to the language.
     *
     * @return ICommandBuilder
     */
    public ICommandBuilder getCommandBuilder() {
        return commandBuilder;
    }
}
