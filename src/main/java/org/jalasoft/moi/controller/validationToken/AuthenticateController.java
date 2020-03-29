/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.validationToken;

import io.swagger.annotations.Api;
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

@RestController
@RequestMapping("/authenticate")
@Api(value = "authenticate")
public class AuthenticateController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private MoiUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest autRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(autRequest.getUsername(), autRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(autRequest.getUsername());
//        final String jwt = jwtTokenUtil.generateToken(userDetails.getUsername(), "admin");
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
}
