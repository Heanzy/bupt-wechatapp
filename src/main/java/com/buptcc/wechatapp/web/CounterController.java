package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xgp
 * @date: 2019/1/18 10:58
 */
@RestController
public class CounterController {
    @Autowired
    private CounterService counterService;

    @RequestMapping("/updateImageCounter")
    public boolean updateImageCounter(Counter counter){return counterService.updateImageCounter(counter);}

    @RequestMapping("/updatePv")
    public boolean updatePv(Counter counter){return counterService.updatePv(counter);}

    @RequestMapping("/updataUn")
    public boolean updataUn(Counter counter){return counterService.updataUn(counter);}

    @RequestMapping("/getCounter")
    public Counter getCounter(Integer counterId){return counterService.getCounter(counterId);}
}
