/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;
import org.jalasoft.moi.controller.services.FileService;
import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.domain.FileCode;
import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * This class defines the controller for C++.
 *
 * @author Diego Perez
 *         Carlos Meneses
 *         Lucero Quiroga
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/cpp")
@Api(value = "cplusplus", description = "Implement compile and run code in C++")
public class CppController {

    @Autowired
    private FileService fileService;
    @Autowired
    private ProcessCache cache;
    private static final String FILE_PATH = ".\\temp\\cplusplus\\";
    private static final String EXTENSION = ".cpp";
    private Language language = Language.CPP;

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution
     */
    @RequestMapping(method = RequestMethod.POST, path = "/execute")
    public String executeCode(@RequestBody FileCode fileCode) throws IOException {
        Handler handler = new Handler(cache);
        Parameters codeParams = fileService.saveFileByBody(fileCode, FILE_PATH, EXTENSION, language);
        return handler.runProgram(codeParams).wrappedResult();
    }

    /**
     * This method is used to save the changes in a file determined by a name.
     *
     * @return a message of the realized action
     */
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public String saveFile(@RequestBody FileCode fileCode) throws IOException {
        fileService.saveFileByBody(fileCode, FILE_PATH, EXTENSION, language);
        return "Your code was successfully saved";
    }
}
