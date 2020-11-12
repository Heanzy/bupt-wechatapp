package com.buptcc.wechatapp.utils;

import com.buptcc.wechatapp.service.Instance.CreateCarpetPatternImp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestAll {

    public static void main(String[] args) {
        CreateCarpetPatternImp createCarpetPatternImp = new CreateCarpetPatternImp();
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        String mname = String.format("C%02dMI%02d0", i, j);
                        String cname = String.format("C%02dCI%02d0", i, k);
                        String ename = String.format("C%02dEI%02d0", i, l);
                        BufferedImage res = createCarpetPatternImp.combine(ImageUtils.addSuffix(ename), ImageUtils.addSuffix(cname), ImageUtils.addSuffix(mname));
                        String imageName =ename.substring(0,3) + String.format("%05d",count++);
                        String wpath ="F:\\master\\wechat\\result/"+imageName+".png";
                        try {
                            ImageIO.write(res, "png", new File(wpath));
                        } catch (IOException e) {

                        }
                    }
                }
            }
        }

    }
}
