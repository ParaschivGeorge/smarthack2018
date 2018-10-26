package com.losnarghileros.smarthack2018.controller;

import com.losnarghileros.smarthack2018.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
