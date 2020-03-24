/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

import org.jalasoft.moi.model.core.parameters.Result;

public class ResultException extends Exception {

    public ResultException(Throwable cause) {
        super("Result cannot be generated", cause);

    }

    public ResultException(Result result) {
        super("Result cannot be generated" + result.getValue());
    }
}
