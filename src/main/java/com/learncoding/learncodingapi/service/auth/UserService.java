package com.learncoding.learncodingapi.service.auth;

import com.learncoding.learncodingapi.exception.BadResourceException;
import com.learncoding.learncodingapi.exception.ResourceAlreadyExistsException;
import com.learncoding.learncodingapi.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user) throws ResourceAlreadyExistsException, BadResourceException;

    User findByUsername(String username);
    Optional<User> findById(Long id);
}
