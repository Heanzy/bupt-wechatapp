package com.buptcc.wechatapp.utils;

import com.buptcc.wechatapp.domain.CustomImage;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/21 15:11
 */
public class imageRename {

    public static String name(String preName){
        int index=preName.lastIndexOf(".");
        String suffix=preName.substring(index);//获取后缀名
        return UUID.randomUUID().toString().replace("-","")+suffix;
    }

    public static CustomImage buildCustomImage(MultipartHttpServletRequest req) {
        String openId = req.getParameter("openId");
        Integer prodType = Integer.parseInt(req.getParameter("productionType"));
        Integer imageType = Integer.parseInt(req.getParameter("imageType"));
        String name = imageRename.name(req.getParameter("preName"));
        return new CustomImage(openId, prodType, imageType, name);
    }
}