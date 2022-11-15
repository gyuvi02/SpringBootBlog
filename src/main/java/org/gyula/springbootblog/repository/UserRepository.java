package org.gyula.springbootblog.repository;

import org.gyula.springbootblog.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
