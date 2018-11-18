package com.lhh.appservermaster.web;

import com.lhh.appservermaster.domain.User;
import com.lhh.appservermaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user/all")
    public @ResponseBody
    List<User> getUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/user/add")
    public @ResponseBody boolean addUser(User user){
        return userService.userSingup(user);
    }

    @GetMapping("/user")
    public @ResponseBody User getOneUserByID(@RequestParam  Integer userId){
        return userService.getOneUserInfoByID(userId);
    }

    @PostMapping("/user/update")
    public @ResponseBody boolean updateUserInfo(User user){
        return userService.updateUserInfo(user);
    }

    @PostMapping("/user/delete")
    public @ResponseBody boolean deleteUserByID(@RequestParam  Integer userId){
        return userService.deleteUserByID(userId);
    }

}
