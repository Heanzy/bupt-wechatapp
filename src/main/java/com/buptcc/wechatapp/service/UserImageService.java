package com.buptcc.wechatapp.service;

import com.buptcc.wechatapp.domain.UserImage;

/**
 * @author: xgp
 * @date: 2019/1/17 16:59
 */
public interface UserImageService {

    boolean insertImage( UserImage userImage);

    boolean deleteByOpenId(String openId);

    int countByOpenId();
}
