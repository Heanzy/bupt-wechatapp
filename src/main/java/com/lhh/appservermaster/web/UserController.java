package com.lhh.appservermaster.web;

import com.lhh.appservermaster.domain.User;
import com.lhh.appservermaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {

    // private String location = "D:\\app-server\\user-images";
    private String remote = "/home/app-server/user-images";

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

    @PostMapping("/user/img/upload")
    public @ResponseBody String uploadUserImg(@RequestParam("image") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "failed";
        }
        String fullFileName = userService.saveUserImg(multipartFile,remote);
        return fullFileName;
    }

    @GetMapping("/user/userName")
    public @ResponseBody User getUserByName(@RequestParam("userName") String userName){
        return userService.getUserByName(userName);
    }
}
