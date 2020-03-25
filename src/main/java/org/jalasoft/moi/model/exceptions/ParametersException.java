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
 * The ParametersException wraps Java Standard exception related to null Parameters fields.
 *
 * @author Diego Perez
 * @version 1.2
 */
public class ParametersException extends Exception {

    private static Path path;

    public ParametersException(Throwable cause) {
        super("Invalid or Null parameters gere generated.", cause);
    }

    public static Path getPath() {
        return path;
    }
}
