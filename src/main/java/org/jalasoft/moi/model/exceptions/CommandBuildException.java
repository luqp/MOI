/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

import java.nio.file.Path;

/**
 * The CommandBuildException wraps Java Standard exception.
 *
 * @author Diego Perez
 * @version 1.2
 */
public class CommandBuildException extends Exception {

    public CommandBuildException(String msg, Path path) {
        super(msg + path.getClass().getName());
    }

    public CommandBuildException(Throwable cause) {
            super("Command built was not correct.", cause);
    }
}
