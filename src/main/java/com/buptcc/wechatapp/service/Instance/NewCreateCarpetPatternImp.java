package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import com.buptcc.wechatapp.service.UserOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 涉及用户自定义图片的地毯拼接
 * 默认上下左右边框取50宽度
 * 默认中心尺寸为500*300
 * 边框尺寸为600*400
 * 角尺寸为80*80
 */
public class NewCreateCarpetPatternImp extends CreateCarpetPatternImp{

    @Autowired
    private CounterDao counterDao;
    @Autowired
    private UserImageDao userImageDao;
    @Autowired
    private UserOpenIdService userOpenIdService;

    @Override
    public String Combine(String ename, String cname, String mname, String openId){

        final String path="/usr/webchatdata/data_custom/";
        //read
        BufferedImage res = combine(path+ename+".png", path+cname+".png", path+mname+".png");
        //write
        //获取图片计数
        Counter counter = counterDao.getCounter(Counter.getCounterId());
        counter.setImageCounter(counter.getImageCounter()+1);
        String imageName =ename.substring(0,3) + String.format("%05d",counter.getImageCounter());
        String wpath ="/usr/webchatdata/result/"+imageName+".png";
        try {
            ImageIO.write(res, "png", new File(wpath));
        } catch (IOException e) {

        }

        //更新数据库图片计数
        counter.setImageCounter(counter.getImageCounter());
        counterDao.updateImageCounter(counter);

        //更新UserImage表
        UserImage userImage = new UserImage();
        userImage.setUserId(openId);
        userImage.setImageName(imageName);
        userImageDao.insertImage(userImage);

        return userImage.getImageName();
    }

    private BufferedImage combine(String br, String c, String m){

    }

    static BufferedImage plusAll(BufferedImage other, BufferedImage medal) {
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 600; j++) {
                int t = other.getRGB(j, i+50);
                // 如果是透明像素
                if ((t&0xff000000) == 0) {
                    other.setRGB(j,i+50, medal.getRGB(j,i));
                }
            }
        }
        return other;
    }
}
