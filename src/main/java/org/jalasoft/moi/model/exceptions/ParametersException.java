/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

import org.jalasoft.moi.model.core.parameters.Params;

import java.nio.file.Path;

public class ParametersException extends Exception {

    private static Path path;

    public ParametersException(Throwable cause) {
        super("Invalid or Null parameters gere generated.", cause);
    }

    public ParametersException(Throwable cause, Path path) {
        super("Invalid or Null parameters gere generated.", cause);
        this.path = path;
    }

    public static Path getPath() {
        return path;
    }
}
