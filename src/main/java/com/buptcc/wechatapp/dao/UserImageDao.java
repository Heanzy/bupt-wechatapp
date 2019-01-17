package com.buptcc.wechatapp.dao;

import com.buptcc.wechatapp.domain.UserImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserImageDao {
    boolean insertImage(@Param("userImage") UserImage userImage);

    boolean deleteByOpenID(@Param("openId") String openId);

    int countByOpenId(@Param("openId") String openId);

}
