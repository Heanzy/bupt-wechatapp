package com.buptcc.wechatapp.utils;

public class Lab2Rgb {
    public static double[] LAB2RGB(double [] LAB){

        return Xyz2Rgb.XYZ2sRGB(Lab2Xyz.Lab2XYZ(LAB));
    }
}
