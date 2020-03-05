/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
*/

package org.jalasoft.moi.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/")
public class HelloController {

    /**
     * @return a constraint string for a simple example
     */
    @GetMapping
    public String hello() {
        return "Hello!!";
    }

    @PostMapping("{name}")
    public String helloGuest(@PathVariable String name){
        return "Hello " + name + "!!!!";
    }

    @PostMapping("/greet")
    public String helloGuestWithParams(@RequestParam String name){
        return "Hello " + name + "!!!!";
    }
}
