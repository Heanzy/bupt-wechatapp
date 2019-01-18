package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.service.UserOpenIdService;
import com.buptcc.wechatapp.utils.GetOpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserOpenIdServiceImp implements UserOpenIdService {
    private GetOpenIdUtil getOpenIdUtil;
    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Autowired
    private CounterDao counterDao;
    @Override
    public String getUserOpenId(String code) {
        //更新访问量
        Counter counter = counterDao.getCounter(Counter.getCounterId());
        counter.setPv(counter.getPv()+1);
        counterDao.updatePv(counter);

        return getOpenIdUtil.getopenid(appid,code,secret);
    }
}
