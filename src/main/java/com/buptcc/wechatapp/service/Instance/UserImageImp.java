package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: xgp
 * @date: 2019/1/17 16:58
 */
@Service
public class UserImageImp implements UserImageService {
    @Autowired
    private UserImageDao userImageDao;

    @Override
    public boolean insertImage( UserImage userImage){
        return userImageDao.insertImage(userImage);
    }

    @Override
    public boolean deleteByOpenId(String openId)
    {
        return userImageDao.deleteByOpenId(openId);
    }

    @Override
    public int countByOpenId( String openId){
        return userImageDao.countByOpenId(openId);
    }
}
