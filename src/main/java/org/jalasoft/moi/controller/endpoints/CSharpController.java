/**
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;

import org.jalasoft.moi.controller.services.CsharpFileService;
import org.jalasoft.moi.model.core.Params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;

/**
 * This class defines the controller for C#.
 *
 * @author Diego Perez & Carlos Meneses.
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/csharp")
@Api(value = "csharp", description = "Implement compile and run code in C#")//for Swagger
public class CSharpController {

    @Autowired
    private CsharpFileService fileService;

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution.
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public String executeSingleCode(@RequestParam(value = "version")String version,
                                    @RequestParam(value = "fileName")String fileName,
                                    @RequestParam(value = "code")String code) throws IOException {
        Params codeParams = fileService.saveFile(version, fileName, code);
        return fileService.showResponse(codeParams);
    }
}
