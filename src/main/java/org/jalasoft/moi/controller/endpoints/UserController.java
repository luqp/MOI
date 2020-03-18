/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;

import org.jalasoft.moi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class defines the user controller.
 *
 * @author Carlos Meneses.
 * @version 1.1
 */
@Controller
@RequestMapping("/user")
@Api(value = "user", description = "Operations pertaining to manage users")
public class UserController {

     /**
     * This method get a list of all users.
     *
     * @return a list of registered users.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(){
        return "//TO DO";
    }

    /**
     * This method get a user by a id parameter.
     *
     * @param id is the parameter to search a specific user.
     * @return a user find by id.
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable Long id){
        return "//TO DO";
    }

    /**
     * This method insert a new user in to data base.
     *
     * @param newUser is a user to be added by a post method.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addNewUser(@RequestBody User newUser){
        return "//TO DO";
    }

    /**
     * This method update a user in to data base.
     *
     * @param updateUser is a user to be updated by a put method.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String updateUser(User updateUser){
        return "//TO DO";
    }

    /**
     * This method delete a user by the parameter id.
     *
     * @param id is the parameter to be used to delete a user.
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable Long id){
        return "//TO DO";
    }

}