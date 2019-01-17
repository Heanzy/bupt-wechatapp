package com.buptcc.wechatapp.dao;

import com.buptcc.wechatapp.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    /**
     * @return 数据库所有用户信息
     */
    List<User> getAll();

    /**
     *
     * @param ID 用户id
     * @return 根据id返回用户信息
     */
    User getUserByID(@Param("userId") Integer ID);

    /**
     *
     * @param user
     * @return true 成功添加用户信息至数据库
     */
    boolean addUser (@Param("user") User user);

    /**
     *
     * @param user
     * @return true 成功更新用户信息
     */
    boolean updateUserInfoByID(@Param("user")User user);

    /**
     *
     * @param ID
     * @return true 成功删除用户信息
     */
    boolean deleteUserByID(@Param("userId") Integer ID);

    /**
     *
     * @param userName
     * @return 根据用户名查询用户信息
     */
    User getUserByName(@Param("userName") String userName);

    /**
     *
     * @param nickName
     * @return 根据昵称查询用户信息
     */
    User getUserByNickName(@Param("nickName") String nickName);
}
