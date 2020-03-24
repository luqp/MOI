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
import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.parameters.Parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Defines the management of controller for C#.
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

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution
     */
    @RequestMapping(method = RequestMethod.POST, path = "/execute")
    public String executeCode(@RequestParam(value = "File Name")String name,
                              @RequestParam(value = "Code") String code,
                              @RequestParam(value = "Project Id") Long projectID) throws IOException {
        fileService.addNewFile(name, code, projectID);
        Handler handler = new Handler(cache);
        Parameters codeParams = fileService.saveFileB64(name, code, projectID);
        return handler.runProgram(codeParams).wrappedResult();
    }
}
