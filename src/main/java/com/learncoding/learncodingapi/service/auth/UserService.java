package com.learncoding.learncodingapi.service.auth;

import com.learncoding.learncodingapi.exception.BadResourceException;
import com.learncoding.learncodingapi.exception.ResourceAlreadyExistsException;
import com.learncoding.learncodingapi.model.ApplicationUser;

import java.util.Optional;

public interface UserService {
    ApplicationUser save(ApplicationUser user) throws ResourceAlreadyExistsException, BadResourceException;

    ApplicationUser findByUsername(String username);
    Optional<ApplicationUser> findById(Long id);
}
