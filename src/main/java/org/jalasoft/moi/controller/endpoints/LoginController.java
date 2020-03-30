/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.swagger.annotations.Api;

import org.jalasoft.moi.controller.services.UserService;
import org.jalasoft.moi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Handles the login whit correct credentials and generates a token.
 *
 * @author Carlos Meneses
 * @version 1.2
 */
@RestController
@RequestMapping("/login")
@Api(value = "login", description = "Login a user and generates a token")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * Builds a token whit the correct credentials.
     *
     * @param username from the data base
     * @param password from the data base
     * @return token
     */
    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        User user = userService.getUserByUserNameAndPassword(username, password);
        String token = getJwtsToken(username, user.getRol());
        userService.save(user);
        return token;
    }


    public String getJwtsToken(String username, String role) {
        String secret = "AWT05Moi";
        long currentTime = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(username)
                .claim("Role", role)
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 600000))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
        return token;
    }
}
