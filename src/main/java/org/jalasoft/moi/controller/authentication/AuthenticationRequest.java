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
 * Contains values to be authenticated.
 *
 * @author Lucero Quiroga Perez
 * @version 1.3
 */
public class AuthenticationRequest {

    private String username;
    private String password;

    /**
     * Default constructor.
     */
    public AuthenticationRequest() {
    }

    /**
     * Defines client data.
     *
     * @param username contains the input user value
     * @param password contains a secret value
     */
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Contains username value.
     *
     * @return a string the value
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes username value.
     *
     * @param username from client
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Contains password secret.
     *
     * @return a string with the secret value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes the secret value.
     *
     * @param password a new secret string.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
