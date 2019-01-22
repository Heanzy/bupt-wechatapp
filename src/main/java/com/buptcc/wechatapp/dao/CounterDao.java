package com.buptcc.wechatapp.dao;

import com.buptcc.wechatapp.domain.Counter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author Heanzy
 *
 */
@Component
public interface CounterDao {
    boolean updateImageCounter(@Param("counter")Counter counter);

    boolean updatePv(@Param("counter")Counter counter);

    boolean updateUn(@Param("counter")Counter counter);

    Counter getCounter(@Param("counterId") Integer counterId);
}
