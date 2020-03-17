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
import org.jalasoft.moi.model.core.IHandler;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.parameters.InputParams;
import org.jalasoft.moi.model.python.PythonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/onlineCompiler/q")
@Api(value = "userInteraction", description = "Handle user interaction")
public class LanguageController {

    @Autowired
    private FileService service;
    private ProcessCache cache;

    @RequestMapping(method = RequestMethod.PUT)
    public String processInput(@RequestParam(value = "userInput") String userInput,
                               @RequestParam(value = "pid") Long pid,
                               @RequestParam(value = "language") Language language) {
        InputParams params = new InputParams();
        params.setInput(userInput);
        params.setProcessPid(pid);
        IHandler handler = getHandler(language);
        return handler.processInput(params).getResult();
    }

    private IHandler getHandler(Language language) {
        switch (language) {
            case PYTHON_32:
                return new PythonHandler(cache);
            default:
                throw new IllegalArgumentException("Incorrect Language");
        }
    }
}
