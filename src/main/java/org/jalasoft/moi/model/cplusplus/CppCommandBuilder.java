/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.cplusplus;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;

public class CppCommandBuilder implements ICommandBuilder {

    /**
     * Build the command for C++
     * @param path contains the location of the directory or file
     * @return The commands to compile the code
     */
    @Override
    public String buildCommand(Path path) {
        String CPPCOMPILERPATH = "C:\\MinGW\\bin\\";
        String OUTPUTFILEPATH = "./temp/test.exe";
        String CPPCOMPILECOMMAND = "c++.exe ";

        String actualPath = System.getProperty("user.dir");
        String compileCommands =
                " cd " + CPPCOMPILERPATH +
                " && " + CPPCOMPILECOMMAND + path +
                " -o " + OUTPUTFILEPATH +
                " && cd " + actualPath +
                " && " + OUTPUTFILEPATH;
        return (compileCommands);
    }
}
