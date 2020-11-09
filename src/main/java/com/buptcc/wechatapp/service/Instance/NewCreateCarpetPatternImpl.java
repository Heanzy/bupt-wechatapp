package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.UserOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewCreateCarpetPatternImpl extends CreateCarpetPatternImp{

    @Autowired
    private CounterDao counterDao;
    @Autowired
    private UserImageDao userImageDao;
    @Autowired
    private UserOpenIdService userOpenIdService;

    String systemPath = "/usr/webchatdata/data/";

    String customPath = "/usr/webchatdata/data_custom/";

    public static void main(String[] args) {
        File f = new File("E:/xxfx.txt");
        System.out.println(f.exists());
    }


    @Override
    public String Combine(String  ename, String cname, String mname, String openId){

        //read
        BufferedImage res = combine(ename+".png", cname+".png", mname+".png");
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

    /**
     * 获取文件
     * @param name
     * @return
     */
    private File getFile(String name) {
        File file = new File(systemPath + name);
        if (file.exists()){
            return file;
        }else {
            return new File(customPath + name);
        }
    }

    private BufferedImage combine(String br, String c,String m){
        BufferedImage medal=null,corner=null,brink=null;
        try {
            medal = ImageIO.read(getFile(m));
            corner = ImageIO.read(getFile(c));
            brink = ImageIO.read(getFile(br));
        } catch (IOException e) {

        }
        int[] b = new int[]{50, 549, 50, 349};
        corner = colorTrans(corner,medal);
        brink = colorTrans(brink,medal);
        return plusAll(CornerPlusBrink(corner,brink,b),medal);

    }
}
