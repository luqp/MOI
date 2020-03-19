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
import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * This class defines the controller for C#.
 *
 * @author Diego Perez
 *         Carlos Meneses
 *         Lucero Quiroga
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/csharp")
@Api(value = "csharp", description = "Implement compile and run code in C#")//for Swagger
public class CSharpController {

    @Autowired
    private FileService fileService;
    @Autowired
    private ProcessCache cache;
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
        Handler handler = new Handler(cache);
        Parameters codeParams = fileService.saveFile(name, code, FILE_PATH, EXTENSION, language);
        return writeResult(handler.runProgram(codeParams));
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

    private String writeResult(Result result) {
        return result.getPid() + "\n" + result.getValue();
    }
}
