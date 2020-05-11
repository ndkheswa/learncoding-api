package com.learncoding.learncodingapi.service.auth;

import com.learncoding.learncodingapi.exception.BadResourceException;
import com.learncoding.learncodingapi.exception.ResourceAlreadyExistsException;
import com.learncoding.learncodingapi.model.ApplicationUser;
import com.learncoding.learncodingapi.repository.ApplicationUserRepository;
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
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private boolean existsById(Long id) { return applicationUserRepository.existsById(id); }

    @Override
    public ApplicationUser save(ApplicationUser user) throws ResourceAlreadyExistsException, BadResourceException {
        if (!StringUtils.isEmpty(user.getUsername())) {
            if (user.getId() != null) {
                if (this.existsById(user.getId())) {
                    throw new ResourceAlreadyExistsException("User with id: " + user.getId() +
                            " already exists!");
                }
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return applicationUserRepository.save(user);

        } else {
            var e = new BadResourceException("Couldn't save user!");
            e.addErrorMessage("User is null or empty");
            throw e;
        }
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    @Override
    public Optional<ApplicationUser> findById(Long id) {
        return applicationUserRepository.findById(id);
    }
}
