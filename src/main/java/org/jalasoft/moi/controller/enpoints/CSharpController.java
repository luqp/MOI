/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.enpoints;

import io.swagger.annotations.Api;

import org.jalasoft.moi.controller.sevices.CsharpFileService;
import org.jalasoft.moi.model.core.Params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * This class defines the controller for C#.
 *
 * @author Diego Perez
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/onlineCompiler/csharp")
@Api(value = "csharp", description = "Implement compile and run code in Csharp")//for Swagger
public class CSharpController {

    @Autowired
    private CsharpFileService fileService;

    /**
     * Returns a String that shows the output of the program. A JSON serves as
     * the input needed for a next call.
     *
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
