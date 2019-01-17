package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.UserOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserServiceController {
    @Autowired
    UserOpenIdService userOpenIdService;
    public String getUserOpenId(@RequestParam("code") String code){
        return userOpenIdService.getUserOpenId(code);
    }
}
