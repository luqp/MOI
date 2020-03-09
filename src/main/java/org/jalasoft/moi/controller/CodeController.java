/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import org.jalasoft.moi.model.ICommandBuilder;
import org.jalasoft.moi.model.Params;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * This class defines the controller for the data sent from every endpoint.
 */
@RestController("/api")
public class CodeController {

    private Params codeParams;
    private final CodeHandler codeHandler = new CodeHandler();

    /**
     * This method is used for communication between the model and the client.
     * @param language that the user sends as programming language to use
     * @param version of the programming language
     * @param fileName provided by user to its file to be created
     * @param code sent form user as input to be compiled and executed
     * @return the output from the execution
     */
    @RequestMapping(path = "/v1/onlineCompiler", method = RequestMethod.PUT, consumes = "application/json")
    public String executeSingleCode(@RequestBody String language, String version, String fileName, String code) {
        codeParams = codeHandler.codeParams(fileName, code, language, version);
        String result = codeHandler.execCode(codeParams);
        return result;
    }
}
