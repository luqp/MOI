/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;

import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Handler is in charge to work with the executer and the command builder
 *
 * @version 1.0
 * @author Carlos Meneses
 */
public interface IHandler {

    /**
     * @param params contains the parameters to build a command a execute it
     * @return a String of result from CommandBuilder and Executer handling
     */
    String execute(Params params);

    /**
     * Returns a Params object.
     * A JSON object gets deconstructed and its data used to make a
     * Params object.
     * @param jsonRequest A string ready to be decomposed into variables.
     * @return A Params object.
     * @throws IOException
     * @throws ParseException
     */
    Params codeParams(String jsonRequest) throws IOException, ParseException;
}
