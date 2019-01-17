package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreatePatternController {
    @Autowired
    private CreateCarpetPatternService createCarpetPatternService;
    @PostMapping("/test/")
    public String Combine(@RequestParam String ename,String cname,String mname){return createCarpetPatternService.Combine(ename, cname, mname);}
}
