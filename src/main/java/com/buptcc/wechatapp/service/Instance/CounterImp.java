package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.CounterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: xgp
 * @date: 2019/1/18 10:51
 */
@Service
public class CounterImp implements CounterService {
    @Autowired
    private CounterDao counterDao;

    @Override
    public boolean updateImageCounter(Counter counter){return counterDao.updateImageCounter(counter);}

    @Override
    public boolean updatePv(Counter counter){return counterDao.updatePv(counter);}

    @Override
    public boolean updataUn(Counter counter){return counterDao.updataUn(counter);}

    @Override
    public Counter getCounter(Integer counterId){return counterDao.getCounter(counterId);}
}
