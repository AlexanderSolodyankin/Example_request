package com.example.demo.service;


import com.example.demo.models.UserModel;

public interface UserService {
    UserModel[] getAllUsers();
    UserModel newUser(UserModel user);
    UserModel deleteUser(UserModel user);
    UserModel updateUser(UserModel user);

}
