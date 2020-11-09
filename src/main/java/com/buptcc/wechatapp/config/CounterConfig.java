package com.buptcc.wechatapp.config;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Heanzy
 */
@Configuration
@EnableScheduling
public class CounterConfig {
    @Autowired
    UserImageDao userImageDao;
    @Autowired
    CounterDao counterDao;
    // 每日零点更新
    @Scheduled(cron = "0 0 0 * * ?")
    private void countTask() {
        int userCount = userImageDao.countByOpenId();
        Counter counter = new Counter(0,0,userCount);
        counterDao.updateUn(counter);
    }
}
