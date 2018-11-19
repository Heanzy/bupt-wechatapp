package com.lhh.appservermaster.service.Instance;

import com.lhh.appservermaster.dao.UserDao;
import com.lhh.appservermaster.domain.User;
import com.lhh.appservermaster.service.UserService;
import com.lhh.appservermaster.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class UserServiceimp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean userSingup(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userDao.updateUserInfoByID(user);
    }

    @Override
    public boolean deleteUserByID(Integer ID) {
        return userDao.deleteUserByID(ID);
    }

    @Override
    public String saveUserImg(MultipartFile multipartFile, String path) {
        String fullFileName = null;
        try {
            fullFileName = Utils.getInstance().saveImg(multipartFile,path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        fullFileName = path + File.separator + fullFileName;
        return fullFileName;
    }

    @Override
    public User getOneUserInfoByID(Integer ID){
        return userDao.getUserByID(ID);
    }
}
