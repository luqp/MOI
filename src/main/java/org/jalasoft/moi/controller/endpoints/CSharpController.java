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

import org.jalasoft.moi.model.csharp.CsharpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * This class defines the controller for C#.
 *
 * @author Diego Perez.
 *         Carlos Meneses.
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/csharp")
@Api(value = "csharp", description = "Implement compile and run code in C#")//for Swagger
public class CSharpController {

    @Autowired
    private FileService fileService;
    private static final String FILE_PATH = ".\\temp\\csharp\\";
    private static final String EXTENSION = ".cs";
    private Language language = Language.CSHARP;

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/execute")
    public String executeCode(@RequestParam String name,
                              @RequestParam String code) throws IOException {
        IHandler handler = new CsharpHandler();
        Params codeParams = fileService.saveFile(name, code, FILE_PATH, EXTENSION, language);
        return handler.execute(codeParams);
    }

    /**
     * This method is used to save the changes in a file determined by a name.
     *
     * @return a message of the realized action.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public String saveFile(@RequestParam String name,
                           @RequestParam String code) throws IOException {
        fileService.saveFile(name,code, FILE_PATH, EXTENSION, language);
        return "Your code was successfully saved";
    }
}
