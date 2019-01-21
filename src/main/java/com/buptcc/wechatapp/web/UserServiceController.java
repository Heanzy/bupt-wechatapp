package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.OpenIdMessage;
import com.buptcc.wechatapp.service.UserOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Heanzy
 */
@RestController
public class UserServiceController {
    @Autowired
    UserOpenIdService userOpenIdService;
    @Autowired
    OpenIdMessage openIdMessage;
    @GetMapping("mini/getOpenId")
    public OpenIdMessage getUserOpenId(@RequestParam("code") String code){
        openIdMessage.setOpenId(userOpenIdService.getUserOpenId(code));
        return openIdMessage;
    }
}
