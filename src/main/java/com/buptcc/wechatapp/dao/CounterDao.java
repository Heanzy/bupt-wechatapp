package com.buptcc.wechatapp.dao;

import com.buptcc.wechatapp.domain.Counter;
import org.apache.ibatis.annotations.Param;

public interface CounterDao {
    boolean updateImageCounter(@Param("counter")Counter counter);

    boolean updatePv(@Param("counter")Counter counter);

    boolean updataUn(@Param("counter")Counter counter);

}
