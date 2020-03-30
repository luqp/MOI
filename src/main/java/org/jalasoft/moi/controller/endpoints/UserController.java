/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;

import org.jalasoft.moi.controller.services.UserService;
import org.jalasoft.moi.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles the CRUD basic operations.
 *
 * @author Carlos Meneses
 * @version 1.2
 */
@RestController
@RequestMapping(path = "/user")
@Api(value = "user", description = "Operations pertaining to manage users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets a list of all users.
     *
     * @return a list of users
     */
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Gets a user by a id parameter.
     *
     * @param id to search a specific user
     * @return contains a user found by id
     */
    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Inserts a new user in to data base.
     *
     * @param firstName inserts the new user name
     * @param lastName inserts the new user last name
     * @param email inserts the new user email
     * @param userName inserts the new user username
     * @param password inserts the new user password
     * @return contains the inserted user information
     */
    @PostMapping(path = "/new")
    public User addNewUser(@RequestParam(value = "First Name") String firstName,
                           @RequestParam(value = "Last Name", required = false) String lastName,
                           @RequestParam(value = "E-mail", required = false) String email,
                           @RequestParam(value = "Username") String userName,
                           @RequestParam(value = "Password") String password) {
        return userService.addNewUser(firstName, lastName, email, userName, password);
    }

    /**
     * Updates a user information in the data base.
     *
     * @param id finds a user to be updated
     * @param firstName updates the name field
     * @param lastName updates the last name field
     * @param email updates the email field
     * @return contains the updated user information
     */
    @PutMapping(path = "/info/{id}")
    public User updateUserInfo(@PathVariable Long id,
                               @RequestParam(value = "First Name") String firstName,
                               @RequestParam(value = "LastName", required = false) String lastName,
                               @RequestParam(value = "E-mail",required = false) String email) {
        return userService.updateUserInfo(id, firstName, lastName, email);
    }

    /**
     * Updates a user credentials in the data base.
     *
     * @param id finds a user to be updated
     * @param userName updates the username field
     * @param pass updates the password field
     * @return contains the updated user information
     */
    @PutMapping(path = "/credentials/{id}")
    public User updateUserCredentials(@PathVariable Long id,
                                      @RequestParam(value = "Username") String userName,
                                      @RequestParam(value = "Password") String pass) {
        return userService.updateUserCredentials(id, userName, pass);
    }

    /**
     * Updates a user rol inside the data base.
     *
     * @param id finds a user to be updated
     * @param rol updates the user rol field
     * @return contains the updated user information
     */
    @PutMapping(path = "/rol/{id}")
    public User updateUserRol(@PathVariable Long id,
                              @RequestParam(value = "Rol", defaultValue = "user") String rol) {
        return userService.updateUserRol(id, rol);
    }

    /**
     * Deletes a user by the parameter id.
     *
     * @param id to search for the user to delete.
     */
    @DeleteMapping(path = "/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
