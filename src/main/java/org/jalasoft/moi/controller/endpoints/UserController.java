package org.jalasoft.moi.controller.enpoints;

import io.swagger.annotations.Api;
import org.jalasoft.moi.controller.sevices.UserService;
import org.jalasoft.moi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
@Api(value = "user", description = "Operations pertaining to manage users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * This method get a list of all users.
     *
     * @return a list of registered users.
     */
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * This method get a user by a id parameter.
     *
     * @param id is the parameter to search a specific user.
     * @return a user find by id.
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * This method insert a new user in to data base.
     *
     * @param newUser is a user to be added by a post method.
     */
    @RequestMapping(method = RequestMethod.POST)
    public void addNewUser(@RequestBody User newUser) {
        System.out.println("The new user is: " + newUser);
        userService.addNewUser(newUser);
    }

    /**
     * This method update a user in to data base.
     *
     * @param updateUser is a user to be updated by a put method.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(User updateUser) {
        userService.updateUser(updateUser);
    }

    /**
     * This method delete a user by the parameter id.
     *
     * @param id is the parameter to be used to delete a user.
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable Long id) {
        System.out.println("The id teacher deleted is " + id);
        userService.deleteUser(id);
    }

}
