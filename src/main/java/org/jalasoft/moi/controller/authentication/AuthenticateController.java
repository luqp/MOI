/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.authentication;

import io.swagger.annotations.Api;
import org.jalasoft.moi.controller.services.MoiUserDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Determines whether user is who declares itself to be.
 *
 * @author Lucero Quiroga Perez
 * @version 1.3
 */
@RestController
@RequestMapping("/authenticate")
@Api(value = "authenticate")
public class AuthenticateController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticateController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MoiUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * Verifies username and password and generate a new token if the values
     * are valid.
     *
     * @param autRequest contains the username and password inserted by the client
     * @return ResponseEntity 'OK' with the token value
     * @throws Exception when data are wrong
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest autRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(autRequest.getUsername(), autRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            LOGGER.error("Incorrect username<{}> or password", autRequest.getUsername());
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(autRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
