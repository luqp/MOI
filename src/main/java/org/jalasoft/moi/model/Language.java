/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model;

import java.nio.file.Paths;

/**
 * Represent the supported languages and give access to the appropriate command builder.
 */
public enum Language {
    PYTHON_37(new PythonCommandBuilder(Paths.get("/thirdparty/python/win/Python37/python.exe"), "37"));

    private final ICommandBuilder commandBuilder;

    /**
     * @param commandBuilder of a specific language and version.
     */
    Language(ICommandBuilder commandBuilder) {
        this.commandBuilder = commandBuilder;
    }

    public ICommandBuilder getCommandBuilder() {
        return commandBuilder;
    }
}
