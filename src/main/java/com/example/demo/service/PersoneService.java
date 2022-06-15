package com.example.demo.service;


import com.example.demo.models.PersoneModel;
import com.example.demo.models.UserModel;

public interface PersoneService {
    PersoneModel getAllPerson(PersoneModel persone);
    PersoneModel getUserInfo(UserModel user);
    PersoneModel newPersoneInfo(PersoneModel persone);
    PersoneModel deletePersoneInfo(PersoneModel persone);
    PersoneModel updatePersone(PersoneModel persone);
}
