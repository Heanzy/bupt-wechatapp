package com.buptcc.wechatapp.web;


import com.buptcc.wechatapp.service.UserCustomImageService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserCustomImageController {

    @Autowired
    UserCustomImageService userCustomImageService;

    @GetMapping("/customImage")
    public Map<String, List<List<String>>> getUserCustomImage(String openId, int subjectType) {
        return userCustomImageService.getUserCustomImage(openId, subjectType);
    }

    @DeleteMapping("/customImage")
    public boolean deleteCustomImage(String openId, String name){
        return userCustomImageService.deleteCustom(openId, name);
    }
}
