package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.UserImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xgp
 * @date: 2019/1/17 17:06
 */
@Controller
public class UserImageController {
    private UserImageService userImageService;
    @RequestMapping("/insertImage")
    public boolean insertImage(@RequestParam UserImage userImage){return userImageService.insertImage(userImage);}


    @RequestMapping("/countByOpenId")
    public int countByUserId(@RequestParam String openId){return userImageService.countByOpenId(openId);}
}
