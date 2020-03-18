/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;
import org.jalasoft.moi.controller.services.FileService;
import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.parameters.Answer;
import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contains language behavior.
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/onlineCompiler/q")
@Api(value = "userInteraction", description = "Handle user interaction")
public class LanguageController {

    @Autowired
    private FileService service;
    private ProcessCache cache;

    /**
     * Handles the user input and processes an result.
     *
     * @param userInput contains the a string
     * @param pid contains the process id
     * @return String with the result value
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String processInput(@RequestParam(value = "userInput") String userInput,
                               @RequestParam(value = "pid") Long pid) {
        InputParameters answer = new Answer();
        answer.setValue(userInput);
        answer.setProcessPid(pid);
        Handler handler = new Handler(cache);
        return writeResult(handler.processInput(answer));
    }

    /**
     * Modifies the result output.
     *
     * @param result initial result
     * @return String with pid + result
     */
    private String writeResult(Result result) {
        return result.getPid() + "\n" + result.getValue();
    }
}
