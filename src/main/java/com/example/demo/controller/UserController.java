package com.example.demo.controller;


import com.example.demo.models.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService = new UserServiceImpl();

    @GetMapping("/getAll")
    public UserModel[] getAllUsers(){
        return userService.getAllUsers();
    }

}
