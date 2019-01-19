package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.UserOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {
    @Autowired
    UserOpenIdService userOpenIdService;
    @GetMapping("/getOpenId")
    public String getUserOpenId(@RequestParam("code") String code){
        return userOpenIdService.getUserOpenId(code);
    }
}
