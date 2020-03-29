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

import org.jalasoft.moi.controller.services.ProcessService;
import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.parameters.Answer;
import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.InputParametersException;
import org.jalasoft.moi.model.exceptions.ParametersException;
import org.jalasoft.moi.model.exceptions.ProcessIDException;
import org.jalasoft.moi.model.exceptions.ResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * Contains language behavior.
 *
 * @author Lucero Quiroga Perez
 *         Carlos Meneses
 * @version 1.3
 */
@RestController
@RequestMapping(path = "/execute")
@Api(value = "userInteraction", description = "Execute a Project code and handle user interaction")
public class ExecuteCodeController {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Autowired
    private ProcessService processService;

    /**
     * Returns a String that shows the output of the program.
     *
     * @param projectId URL param that points to the project id that will be executed
     * @return the output from the execution
     */
    @GetMapping(path = "/run/project/{projectId}")
    public String runCode(@PathVariable Long projectId) throws IOException {
        Handler handler = new Handler(processService);
        Parameters codeParams = processService.setParams(projectId);
        LOGGER.info("Project id retrieved from URL: {}", projectId);
        HttpServletResponse response = null;
        try {
            return handler.runProgram(codeParams).wrappedResult();
        } catch (ResultException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (CommandBuildException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (ParametersException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (ProcessIDException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Handles the user input and processes an result.
     *
     * @param userInput contains the a string
     * @param pid contains the process id
     * @return String with the result value
     */
    @PostMapping(path = "/arguments/input")
    public String processInput(@RequestParam(value = "userInput") String userInput,
                               @RequestParam(value = "pid") Long pid) throws IOException {
        InputParameters answer = new Answer();
        answer.setValue(userInput);
        answer.setProcessPid(pid);
        Handler handler = new Handler(processService);
        HttpServletResponse response = null;
        try {
            return handler.processInput(answer).wrappedResult();
        } catch (ResultException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (InputParametersException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        }
    }
}
