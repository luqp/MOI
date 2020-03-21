package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.domain.User;
import org.jalasoft.moi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

//    public User getUserById(Long id) {
//        return repository.findUserById(id);
//
//    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User addNewUser(User newUser) {
        return repository.save(newUser);
    }

    public User updateUser(User updateUser) {
        return repository.save(updateUser);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
