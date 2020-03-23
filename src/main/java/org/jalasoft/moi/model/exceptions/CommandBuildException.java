/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

public class CommandBuildException extends Exception {

    public CommandBuildException() {
        super();
    }

    public CommandBuildException(String msg) {
        super(msg);
    }

    public CommandBuildException(String msg, String command) {
        super(msg.concat(command));
    }
}
