package org.jalasoft.moi.repository;

import org.jalasoft.moi.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
}
