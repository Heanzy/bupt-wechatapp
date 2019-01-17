package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.User;
import com.buptcc.wechatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {

    // TODO 改进至配置文件
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

    @GetMapping("/user/nickName")
    public @ResponseBody User getUserByNickName(@RequestParam("nickName") String nickName){
        return userService.getUserByNickName(nickName);
    }
}
