/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.domain.User;
import org.jalasoft.moi.controller.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides to controller the CRUD basic operations.
 *
 * @author Carlos Meneses
 *         Lucero Quiroga Perez
 * @version 1.3
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Gets a list of all users.
     *
     * @return a list of users
     */
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    /**
     * Get a user by username parameter.
     *
     * @param username inserts to search user
     * @return User found by username.
     */
    public User getUserByUserName(String username) {
        return repository.findByUserName(username);
    }

    /**
     * Gets a user by a id parameter.
     *
     * @param id to search a specific user
     * @return contains a user found by id
     */
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Inserts a new user in to data base.
     *
     * @param name inserts the new user name
     * @param lastName inserts the new user last name
     * @param email inserts the new user email
     * @param userName inserts the new user username
     * @param password inserts the new user password
     * @return contains the inserted user information
     */
    public User addNewUser(String name, String lastName, String email, String userName, String password) {
        User newUser = new User();
        newUser.setFirstName(name);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setRol("user");
        return repository.save(newUser);
    }

    /**
     * Updates a user information in the data base.
     *
     * @param id finds a user to be updated
     * @param name updates the name field
     * @param lastName updates the last name field
     * @param email updates the email field
     * @return contains the updated user information
     */
    public User updateUserInfo(Long id, String name, String lastName, String email) {
        User userToUpdate = repository.findById(id).get();
        userToUpdate.setFirstName(name);
        userToUpdate.setLastName(lastName);
        userToUpdate.setEmail(email);
        return repository.save(userToUpdate);
    }

    /**
     * Updates a user rol inside the data base.
     *
     * @param id finds a user to be updated
     * @param rol updates the name field
     * @return contains the updated user information
     */
    public User updateUserRol(Long id, String rol) {
        User userToUpdate = repository.findById(id).get();
        userToUpdate.setRol(rol);
        return repository.save(userToUpdate);
    }

    /**
     * Updates a user credentials in the data base.
     *
     * @param id finds a user to be updated
     * @param userName updates the username field
     * @param pass updates the password field
     * @return contains the updated user information
     */
    public User updateUserCredentials(Long id, String userName, String pass) {
        User userToUpdate = repository.findById(id).get();
        userToUpdate.setUserName(userName);
        userToUpdate.setPassword(pass);
        return repository.save(userToUpdate);
    }

    /**
     * Deletes a user by the parameter id.
     *
     * @param id to search for the user to delete.
     */
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
