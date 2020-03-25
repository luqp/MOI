/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.model.core.Executer;
import org.junit.Test;

public class CommandBuildExceptionTest {

    @Test(expected = CommandBuildException.class)
    public void throwsExceptionWhenCommandNullTest() throws CommandBuildException, ResultException {
        Executer executer = new Executer(new ProcessCache());
        executer.execute(null);
    }

    @Test(expected = CommandBuildException.class)
    public void throwsExceptionWhenCommandInvalidTest() throws CommandBuildException, ResultException {
        Executer executer = new Executer(new ProcessCache());
        executer.execute("wrong");
    }
}