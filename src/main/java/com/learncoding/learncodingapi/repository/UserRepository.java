package com.learncoding.learncodingapi.repository;

import com.learncoding.learncodingapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
