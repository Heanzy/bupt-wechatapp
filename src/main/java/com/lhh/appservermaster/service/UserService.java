package com.lhh.appservermaster.service;

import com.lhh.appservermaster.domain.User;
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
     *
     * @param ID 用户id
     * @return true 根据用户id删除用户信息
     */
    boolean deleteUserByID(Integer ID);

}

