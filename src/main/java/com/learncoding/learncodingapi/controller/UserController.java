package com.learncoding.learncodingapi.controller;

import com.learncoding.learncodingapi.exception.BadResourceException;
import com.learncoding.learncodingapi.exception.ResourceAlreadyExistsException;
import com.learncoding.learncodingapi.model.ApplicationUser;
import com.learncoding.learncodingapi.service.auth.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApplicationUser> register(@RequestBody ApplicationUser user) throws URISyntaxException {
        try {
            var newUser = userService.save(user);
            return ResponseEntity.created(new URI("/users/sign-up/" + newUser.getId()))
                    .body(user);
        } catch (ResourceAlreadyExistsException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (BadResourceException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
