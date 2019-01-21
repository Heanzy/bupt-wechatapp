package com.buptcc.wechatapp.utils;

public class ImageName2MatName {
    ImageName2MatName(){

    }
    public static String imageName2MatName(String imageName){
        char [] result1 = imageName.toCharArray();
        result1[4] = 'S';
        String result = new String(result1);
        return result;
    }
}
