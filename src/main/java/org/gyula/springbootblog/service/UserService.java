package org.gyula.springbootblog.service;

import org.gyula.springbootblog.domain.User;

public interface UserService {
    public User findByEmail(String email);
}
