/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

import org.jalasoft.moi.model.core.parameters.InputParameters;

public class InputParametersException extends Exception {

    public InputParametersException() {
        super();
    }

    public InputParametersException(String msg) {
        super(msg);
    }

    public InputParametersException(String msg, InputParameters inputParameters) {
        super(msg.concat(inputParameters.getValue()));
    }
}
