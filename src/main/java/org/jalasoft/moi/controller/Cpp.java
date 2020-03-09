/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.controller;

import org.jalasoft.moi.model.ILanguage;
import org.jalasoft.moi.model.Params;

public class Cpp implements ILanguage {

    /**
     *
     * @param params will contain all parameters abut the file that we will use to generate its commands
     * @return
     */
    @Override
    public String commandBuilder(Params params){
        String CPPCOMPILERPATH = "C:\\MinGW\\bin\\";
        String FILEPATH = params.getFilesPath().toString();
        FILEPATH =  "C:\\AWT5\\MOI\\resources\\files\\test.cpp";
        String OUTPUTFILEPATH = "C:\\AWT5\\MOI\\resources\\files\\test.exe";
        String CPPCOMPILECOMMAND = "c++.exe ";

        String actualPath = System.getProperty("user.dir");
        String compileCommands = "cmd /c" +
                " cd " + CPPCOMPILERPATH +
                " && " + CPPCOMPILECOMMAND + FILEPATH +
                " -o " + OUTPUTFILEPATH +
                " && cd " + actualPath;
        System.out.println(compileCommands);
        return (compileCommands);
    }
}
