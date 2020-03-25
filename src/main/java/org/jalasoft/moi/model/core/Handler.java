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
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.InputParametersException;
import org.jalasoft.moi.model.exceptions.ParametersException;
import org.jalasoft.moi.model.exceptions.ProcessIDException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler is in charge to work with the executer and the command builder
 *
 * @author Carlos Meneses
 *         Lucero Quiroga Perez
 *         Diego Perez
 * @version 1.1
 */
public class Handler {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    private ICacheProvider cache;

    public Handler(ICacheProvider cache) {
        this.cache = cache;
    }

    /**
     * Returns the output from the execution of a program.
     *
     * @param params contains the parameters to build a command a execute it
     * @return a String of result from CommandBuilder and Executer handling
     * @throws CommandBuildException
     * @throws ResultException
     * @throws ProcessIDException
     * @throws ParametersException
     */
    public Result runProgram(Parameters params) throws ResultException, CommandBuildException, ParametersException, ProcessIDException {
        String command;
        try {
            ICommandBuilder commandBuilder = params.getLanguage().getCommandBuilder();
            command = commandBuilder.buildCommand(params.getFilesPath());
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
            throw new ParametersException(e);
        }
        Executer executer = new Executer(cache);
        return executer.execute(command);
    }

    /**
     * Handles the user input to recover a result.
     *
     * @param params user inputs
     * @return a result value and the process id
     * @throws InputParametersException
     * @throws ResultException
     */
    public Result processInput(InputParameters params) throws InputParametersException, ResultException {
        Executer executer = new Executer(cache);
        return executer.processAnswer(params);
    }
}
