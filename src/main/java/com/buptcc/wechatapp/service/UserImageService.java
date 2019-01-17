package com.buptcc.wechatapp.service;

import com.buptcc.wechatapp.domain.UserImage;
import org.apache.ibatis.annotations.Param;

/**
 * @author: xgp
 * @date: 2019/1/17 16:59
 */
public interface UserImageService {

    boolean insertImage( UserImage userImage);

    boolean deleteByOpenID(String openId);

    int countByOpenId( String openId);
}
