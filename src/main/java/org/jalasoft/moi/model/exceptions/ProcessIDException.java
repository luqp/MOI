/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.exceptions;

/**
 * The ProcessIDException wraps an exception related to the process id.
 *
 * @author Diego Perez
 * @version 1.2
 */
public class ProcessIDException extends Exception {

    public ProcessIDException(Throwable cause) {
        super("Invalid process ID; id could not be captured.", cause);
    }
}
