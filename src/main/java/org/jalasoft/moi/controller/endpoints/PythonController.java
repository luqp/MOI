/**
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
import org.jalasoft.moi.domain.FileCode;
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.Params;

import org.jalasoft.moi.model.python.PythonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * This class defines the controller for Python.
 *
 * @author Diego Perez.
 *         Carlos Meneses.
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/python")
@Api(value = "python", description = "Implement compile and run code in Python")
public class PythonController {

    @Autowired
    private FileService fileService;
    private static final String FILE_PATH = ".\\temp\\python\\";
    private static final String EXTENSION = ".py";
    private Language language = Language.PYTHON_32;

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/execute", consumes = "application/json")
    public String executeCode(@RequestBody FileCode fileCode) throws IOException {
        IHandler handler = new PythonHandler();
        Params codeParams = fileService.saveFilePython(fileCode, FILE_PATH, EXTENSION, language);
        return handler.execute(codeParams);
    }

    /**
     * This method is used to save the changes in a file determined by a name.
     *
     * @return a message of the realized action.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public String saveFile(@RequestBody FileCode fileCode) throws IOException {
        fileService.saveFilePython(fileCode, FILE_PATH, EXTENSION, language);
        return "Your code was successfully saved";
    }
}
