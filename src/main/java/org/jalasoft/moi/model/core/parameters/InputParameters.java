/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core.parameters;

/**
 * Contains user inputs and an process id.
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
public abstract class InputParameters {

    private long pid;
    private String value;

    /**
     * Contains process id.
     *
     * @return process id
     */
    public long getProcessId() {
        return pid;
    }

    /**
     * Changes process id.
     *
     * @param pid from a running process
     */
    public void setProcessPid(long pid) {
        this.pid = pid;
    }

    /**
     * Contains the user input value.
     *
     * @return a string of user input
     */
    public String getValue() {
        return value;
    }

    /**
     * Changes the user input value.
     *
     * @param value user input value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
