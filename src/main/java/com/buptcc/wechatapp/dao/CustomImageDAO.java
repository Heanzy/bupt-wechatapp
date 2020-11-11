package com.buptcc.wechatapp.dao;

import com.buptcc.wechatapp.domain.CustomImage;
import com.buptcc.wechatapp.domain.CustomImageExample;
import org.springframework.stereotype.Repository;

/**
 * CustomImageDAO继承基类
 */
@Repository
public interface CustomImageDAO extends MyBatisBaseDao<CustomImage, Integer, CustomImageExample> {
}