/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import org.jalasoft.moi.model.cplusplus.CppCommandBuilder;
import org.jalasoft.moi.model.java.JavaCommandBuilder;
import org.jalasoft.moi.model.csharp.CsharpCommandBuilder;
import org.jalasoft.moi.model.python.PythonCommandBuilder;

import java.nio.file.Paths;

/**
 * Represent the supported languages and give access to the appropriate command builder.
 *
 * @author Lucero Quiroga Perez
 * @version 1.0
 */
public enum Language {

    PYTHON_32(new PythonCommandBuilder(Paths.get(getActualPath() + "\\thirdparty\\python\\win" +
            "\\python32\\Portable_Python_3.2.5.1\\App\\python.exe"), "32")),
    CSHARP(new CsharpCommandBuilder()),
    JAVA(new JavaCommandBuilder()),
    CPP(new CppCommandBuilder());

    private final ICommandBuilder commandBuilder;
    private static String getActualPath(){
        return System.getProperty("user.dir");
    }

    /**
     * Set the command builder of a specific language and version
     *
     * @param commandBuilder contains a ICommandBuilder
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
