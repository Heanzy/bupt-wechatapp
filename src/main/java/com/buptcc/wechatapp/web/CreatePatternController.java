package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.domain.CreateMesage;
import com.buptcc.wechatapp.service.CreateBagPatternService;
import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import com.buptcc.wechatapp.utils.ImageName2MatName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Heanzy
 *
 *
 */
@RestController
public class CreatePatternController {
    @Autowired
    CreateMesage createMesage;
    @Autowired
    private CreateCarpetPatternService createCarpetPatternService;

    @RequestMapping("mini/create-cp")
    public CreateMesage Combine(@RequestParam String ename,String cname,String mname, String openId)
    {
        createMesage.setrName(createCarpetPatternService.Combine(ename, cname, mname,openId));
        return createMesage;}

    @Autowired
    private CreateBagPatternService createBagPatternService;

    @RequestMapping("mini/create-bp")
    public CreateMesage createBp(@RequestParam("openId") String openId,
                                 @RequestParam("pName") String pName,
                                 @RequestParam("cName") String cName){
        createMesage.setrName(createBagPatternService.createBagPattern(openId,ImageName2MatName.imageName2MatName(pName),ImageName2MatName.imageName2MatName(cName)));
        return createMesage;
    }

}
