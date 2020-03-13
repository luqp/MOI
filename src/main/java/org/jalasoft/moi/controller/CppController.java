/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Params;
import org.jalasoft.moi.model.csharp.CsharpHandler;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * This class defines the controller for C++.
 *
 * @author Diego Perez
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/onlineCompiler/cpp")
public class CppController {

    private Params codeParams;
    private final IHandler cppHandler = new CsharpHandler();

    /**
     * Returns a String that shows the output of the program.
     * A JSON serves as the input needed for
     * a next call.
     *
     * @param jsonRequest A String representing a JSON.
     * @return the output from the execution.
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public String executeSingleCode(@RequestBody String jsonRequest) throws ParseException, IOException {
        codeParams = cppHandler.convertToParams(jsonRequest);
        return cppHandler.execute(codeParams);
    }
}
