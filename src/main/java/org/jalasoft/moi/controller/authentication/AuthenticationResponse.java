/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.authentication;

/**
 * Contains the active token value that will be sent to the client.
 *
 * @author Lucero Quiroga Perez
 * @version 1.3
 */
public class AuthenticationResponse {

    private final String jwt;

    /**
     * Sets token value.
     *
     * @param jwt is a token that contains the user data
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Contains the token value.
     *
     * @return the token string
     */
    public String getJwt() {
        return jwt;
    }
}
