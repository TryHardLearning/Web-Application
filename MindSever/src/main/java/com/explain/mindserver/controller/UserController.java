package com.explain.mindserver.controller;

import com.explain.mindserver.model.User;
import com.explain.mindserver.repository.UserRepository;
import com.explain.mindserver.service.UserService;
import com.explain.mindserver.shared.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public GenericResponse createUser(@RequestBody User user) {
        userService.save(user);
        return GenericResponse.builder().Message("Successful user saved").build();
    }
}