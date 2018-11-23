package com.lhh.appservermaster.service;

import com.lhh.appservermaster.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {
    /**
     * @return 返回所有已经注册的用户信息
     */
    List<User> getAllUsers();

    /**
     * @param user
     * @return true 注册成功，false注册失败
     */
    boolean userSingup(User user);

    /**
     * @param ID 用户id
     * @return 该用户信息
     */
    User getOneUserInfoByID(Integer ID);

    /**
     * @param user
     * @return true 修改成功，false 修改失败
     */
    boolean updateUserInfo(User user);

    /**
     * 删除用户信息
     * @param ID 用户id
     * @return true 根据用户id删除用户信息
     */
    boolean deleteUserByID(Integer ID);

    /**
     * 保存用户上传的图片
     * @param multipartFile
     * @return 图片UUID
     */
    String saveUserImg(MultipartFile multipartFile,String path);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return 用户信息
     */
    User getUserByName(String userName);

}

