package com.buptcc.wechatapp.service;

import com.buptcc.wechatapp.domain.Counter;
import org.apache.ibatis.annotations.Param;

/**
 * @author: xgp
 * @date: 2019/1/18 10:54
 */
public interface CounterService {
    boolean updateImageCounter(Counter counter);

    boolean updatePv(Counter counter);

    boolean updateUn(Counter counter);

    Counter getCounter(Integer counterId);
}
