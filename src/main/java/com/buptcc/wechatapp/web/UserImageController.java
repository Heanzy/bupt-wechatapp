package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xgp
 * @date: 2019/1/17 17:06
 */
@Controller
public class UserImageController {
    @Autowired
    private UserImageService userImageService;
    @RequestMapping("/insertImage")
    public boolean insertImage(@RequestParam UserImage userImage){return userImageService.insertImage(userImage);}

    @RequestMapping("/deleteByOpenId")
    public boolean deleteByOpenId(@RequestParam String openId){return userImageService.deleteByOpenId(openId);}

    @RequestMapping("/countByOpenId")
    public int countByOpenId(){return userImageService.countByOpenId();}
}
