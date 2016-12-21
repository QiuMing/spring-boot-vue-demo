package com.example.controller;

import com.example.domain.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ming on 2016/12/17.
 */
@CrossOrigin
@RestController
public class UserController {

    @GetMapping("/users")
    public User getUser() {
         return new User(1L, "test");
    }
}
