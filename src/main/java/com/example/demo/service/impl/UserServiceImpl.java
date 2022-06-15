package com.example.demo.service.impl;


import com.example.demo.models.PersoneModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.PersoneService;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private static UserModel[] users = new UserModel[5];
    private PersoneService personInfo = new PersoneServiceImpl();

   public static void startDataBase(){
        for (int i = 0; i < users.length; i++) {
            UserModel user = new UserModel();
            user.setLogin("login " + i);
            user.setPassword("password " + i);
            user.setId(i);
            user.setEmail("email " + i);
            PersoneModel personInfo = new PersoneModel();
            personInfo.setName( user.getLogin() + " name " + i);
            personInfo.setPatrol( user.getLogin() + " patrol " + i);
            personInfo.setSerName( user.getLogin() + " serName " + i);
            personInfo.setAge((int)user.getId() + i);
            personInfo.setPhone( user.getLogin() + " telephone " + i);
            user.setInfoUser(personInfo);
            users[i] = user;
        }
    }



    @Override
    public UserModel[] getAllUsers() {
        return users;
    }

    @Override
    public UserModel newUser(UserModel user) {

        users = dataBase(users, user);
        return user;
    }

    @Override
    public UserModel deleteUser(UserModel user) {
        users = deletElement(users, user);
        return user;
    }

    @Override
    public UserModel updateUser(UserModel user) {
        users[(int)user.getId()] = user;
        return users[(int)user.getId()];
    }

    public UserModel[] dataBase (UserModel[] dataUsers, UserModel newUsers){
        UserModel[] newDataUsers = new UserModel[dataUsers.length + 1];
        for (int i = 0; i < dataUsers.length; i++) {

            newDataUsers[i] = dataUsers[i];
        }
        newDataUsers[newDataUsers.length - 1] = newUsers;

        return newDataUsers;
    }
    public UserModel[] deletElement ( UserModel[] dataUsers, UserModel user){
        int count = 0;
        UserModel[] newArray = new UserModel[dataUsers.length - 1];
        for (int i = 0; i < dataUsers.length; i++) {
            if(dataUsers[i] != user){
                newArray[count] = dataUsers[i];
                count++;
            }

        }
        return newArray;
    }


}
