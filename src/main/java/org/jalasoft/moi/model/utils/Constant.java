/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.utils;

/**
 * Contains more used constants.
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
public enum Constant {

    ROOTPATH(System.getProperty("user.dir"));

    private String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
