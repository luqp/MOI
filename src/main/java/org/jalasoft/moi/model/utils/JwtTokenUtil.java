/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    public String getToken(String username, String role) {
        String secret = "AWT05Moi";
        long currentTime = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(username)
                .claim("Role",role)
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 600000))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
        return token;
    }
}
