package com.buptcc.wechatapp.service.Instance;



import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.UserOpenIdService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: xgp
 * @date: 2019/1/17 10:36
 */
@Service
public class CreateCarpetPatternImp implements CreateCarpetPatternService {
    @Autowired
    private CounterDao counterDao;
    @Autowired
    private UserImageDao userImageDao;
    @Autowired
    private UserOpenIdService userOpenIdService;
    @Override
    public String Combine(String  ename, String cname, String mname, String openId){

        final String path="F:/Mini/data/";
        //read
        BufferedImage res = combine(path+ename+".png", path+cname+".png", path+mname+".png");
        //write
        //获取图片计数
        Counter counter = counterDao.getCounter(Counter.getCounterId());
        counter.setImageCounter(counter.getImageCounter()+1);
        String imageName ="C01" + String.format("%05d",counter.getImageCounter());
        String wpath ="F:/Mini/result/"+imageName+".png";
        try {
            ImageIO.write(res, "png", new File(wpath));
        } catch (IOException e) {
            System.out.println(e);
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

    static BufferedImage load(String path) {
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {

        }
        return img;
    }

    //将角与边叠加
    static BufferedImage CornerPlusBrink(BufferedImage corner, BufferedImage brink,BufferedImage medal){
        int[] b = new int[4];
        int k = 200; //第200行中每一列的R值第一个大于246的点 +2是r，顺序为 B G R
        int z;
        for (z = 0; z < 600; z++) {
            //System.out.println(data[index+j+2]);
            if((brink.getRGB(z,k)&0xff000000) == 0)
                break;
        }
        b[0] = z;
        for (z = 599; z >=0; z--) {
            //System.out.println(data[index+j+2]);
            if((brink.getRGB(z,k)&0xff000000) == 0)
                break;
        }
        b[1] = z;

        z = 300;
        for (k = 0; k < 400; k++) {
            if((brink.getRGB(z,k)&0xff000000) == 0)
                break;
        }
        b[2] = k;
        for (k = 399; k >= 0; k--) {
            if((brink.getRGB(z,k)&0xff000000) == 0)
                break;
        }
        b[3] = k;
        if (corner!=null)
        {
            for(int i = 0; i < corner.getWidth(); i++){
                for (int j = 0; j < corner.getHeight(); j++) {
                    brink.setRGB(i+b[0],j+b[2],corner.getRGB(i,j));
                }
            }
            for(int i = corner.getWidth()-1; i >=0; i--){
                for (int j = 0; j < corner.getHeight(); j++) {
                    brink.setRGB(b[1]-i,j+b[2],corner.getRGB(i,j));
                }
            }

            for(int i = 0; i < corner.getWidth(); i++){
                for (int j = corner.getHeight()-1; j >=0 ; j--) {
                    brink.setRGB(i+b[0],b[3]-j,corner.getRGB(i,j));
                }
            }
            for(int i = corner.getWidth()-1; i >=0; i--){
                for (int j = corner.getHeight()-1; j >=0 ; j--) {
                    brink.setRGB(b[1]-i,b[3]-j,corner.getRGB(i,j));
                }
            }
        }
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 600; j++) {
                int t = brink.getRGB(j, i+50);
                if ((t&0xff000000) == 0) {
                    brink.setRGB(j,i+50, medal.getRGB(j,i));
                }
            }
        }
        return brink;
    }

    static double[] pre(Integer a) {
        double[] c= new double[3];
        c[0] = (double)((a&0xff0000)>>16);
        c[1] = (double)((a&0xff00)>>8);
        c[2] = (double)(a&0xff);
        return c;
    }

    static double distance(double[] a, double[] b){
        double d = 0;
        for (int i = 0; i < 3; i++) {
            d+=Math.pow(a[i]-b[i],2);
        }
        return d;
    }

    static BufferedImage colorTrans(BufferedImage m, BufferedImage medal) {
        Map<Integer,Integer> map = new HashMap<>();//构建hashmap，避免重复计算
        Integer key;
        Integer val;
//        int t = 16777215;

        for (int i = 0; i < m.getWidth(); i++) {
            for (int j = 0; j < m.getHeight(); j++) {
                if((m.getRGB(i,j)&0xff000000)>>24 == 0){
                    continue;
                }
                else {
                    key = m.getRGB(i,j);
                    int p=0,q=0;
                    if(map.get(key)==null) {
                        for (int x = 0; x < medal.getWidth(); x += 50) {
                            for (int k = 0; k < medal.getHeight(); k += 50) {
                                //计算欧式距离
                                double d1 = distance(pre(key), pre(medal.getRGB(x, k)));
                                double d2 = distance(pre(key), pre(medal.getRGB(p, q)));
                                if (d1 < d2) {
                                    p = x;
                                    q = k;
                                }
                            }
                        }
                        val = medal.getRGB(p,q);
                        m.setRGB(i, j, val);
                        map.put(key,val);
                    }
                    else
                    {
                        m.setRGB(i, j, map.get(key));
                    }
                }
            }
        }

        return m;
    }
    private BufferedImage combine(String br, String c,String m){
        BufferedImage medal=null,corner=null,brink=null;
        try {
            medal = ImageIO.read(new File(m));
            corner = ImageIO.read(new File(c));
            brink = ImageIO.read(new File(br));
        } catch (IOException e) {

        }
        corner = colorTrans(corner,medal);
        brink = colorTrans(brink,medal);
        return CornerPlusBrink(corner,brink,medal);

    }

}
