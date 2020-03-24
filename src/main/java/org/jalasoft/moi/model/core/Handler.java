/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.ProcessResult;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.InputParametersException;
import org.jalasoft.moi.model.exceptions.ResultException;

import java.io.IOException;

/**
 * Handler is in charge to work with the executer and the command builder
 *
 * @author Carlos Meneses
 *         Lucero Quiroga Perez
 * @version 1.1
 */
public class Handler {

    private ICacheProvider cache;

    public Handler(ICacheProvider cache) {
        this.cache = cache;
    }

    /**
     * Returns the output from the execution of a program.
     *
     * @param params contains the parameters to build a command a execute it
     * @return a String of result from CommandBuilder and Executer handling
     */
    public Result runProgram(Parameters params) throws ResultException, CommandBuildException {
        ICommandBuilder commandBuilder = params.getLanguage().getCommandBuilder();
        String command = commandBuilder.buildCommand(params.getFilesPath());
        Executer executer = new Executer(cache);
        return executer.execute(command);
    }

    /**
     * Handles the user input to recover a result.
     *
     * @param params user inputs
     * @return a result value and the process id
     */
    public Result processInput(InputParameters params) throws InputParametersException, ResultException {
        Executer executer = new Executer(cache);
        return executer.processAnswer(params);
    }
}
