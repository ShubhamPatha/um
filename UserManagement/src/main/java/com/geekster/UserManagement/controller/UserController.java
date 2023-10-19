package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    //read
    @GetMapping("users")
    List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("users/{userId}")
    User getUser(@PathVariable Integer userId)
    {
        return userService.getUserdetail(userId);
    }

    //create

    @PostMapping("users")
    String addUsers(@Valid @RequestBody List<User> users)
    {
        return userService.createUsers(users);
    }

    //@PostMapping("users")
    //String addUser(@Valid @RequestBody User user)
    //{
      //  return userService.createUser(user);
    //}



    @DeleteMapping("users/{userId}")
    String removeUser(@PathVariable Integer userId)
    {
        return userService.removeUser(userId);
    }

    @PutMapping("users/{userId}")
    String updateuser(@PathVariable Integer userId, User user)
    {
        return userService.updateuser(userId,user);
    }


}