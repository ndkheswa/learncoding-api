package com.learncoding.learncodingapi.service.auth;

import com.learncoding.learncodingapi.exception.BadResourceException;
import com.learncoding.learncodingapi.exception.ResourceAlreadyExistsException;
import com.learncoding.learncodingapi.model.User;
import com.learncoding.learncodingapi.repository.UserRepository;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private boolean existsById(Long id) { return userRepository.existsById(id); }

    @Override
    public User save(User user) throws ResourceAlreadyExistsException, BadResourceException {
        if (!StringUtils.isEmpty(user.getUsername())) {
            if (user.getId() != null) {
                if (this.existsById(user.getId())) {
                    throw new ResourceAlreadyExistsException("User with id: " + user.getId() +
                            " already exists!");
                }
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);

        } else {
            var e = new BadResourceException("Couldn't save user!");
            e.addErrorMessage("User is null or empty");
            throw e;
        }
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
