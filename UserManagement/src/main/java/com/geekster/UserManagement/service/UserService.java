package com.geekster.UserManagement.service;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users) {
        List<User> originalList = getAllUsers();
        originalList.addAll(users);
        return "New users added";

    }

    public String createUser(User user) {
        List<User> originalList = getAllUsers();
        originalList.add(user);
        return "New user added";
    }



    public String removeUser(Integer userID) {

        List<User> originalList = getAllUsers();

        for(User user1: originalList)
        {
            if(user1.getUserId()==userID)
            {
                originalList.remove(user1);
                return "user deleted";
            }
        }

        return  "user not found";
    }




    public User getUserdetail(Integer userID) {

        List<User> originalList = getAllUsers();
User us= new User();
        for(User user1: originalList)
        {
            if(user1.getUserId()==userID)
            {


                us=user1;
            }
        }

return us;



    }





    public String updateuser(Integer userID, User user) {
        List<User> originalList = getAllUsers();

        for(User user1: originalList)
        {
            if(user1.getUserId()==userID)
            {
                user1=user;
                return "updated";
            }
        }

return "not found";
    }

}