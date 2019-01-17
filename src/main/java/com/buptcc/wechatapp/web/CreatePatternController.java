package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.CreateBagPatternService;
import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class CreatePatternController {
    @Autowired
    private CreateCarpetPatternService createCarpetPatternService;
    @RequestMapping("/test")
    public String Combine(@RequestParam String ename,String cname,String mname){return createCarpetPatternService.Combine(ename, cname, mname);}
    @Autowired
    private CreateBagPatternService createBagPatternService;
    @RequestMapping("/create-bp")
    public  String createBp(@RequestParam("openId") String openId,
                    @RequestParam("pName") String pName,
                    @RequestParam("cName") String cName){
        return createBagPatternService.createBagPattern(openId,pName,cName);
    }
}
