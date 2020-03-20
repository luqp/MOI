package org.jalasoft.moi.controller.sevices;

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

    public User getUserById(Long id) {
        return repository.findUserById(id);

    }

    public void addNewUser(User newUser) {
        repository.save(newUser);
    }

    public void updateUser(User updateUser) {
        repository.save(updateUser);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
