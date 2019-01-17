package com.buptcc.wechatapp.service.Instance;

import java.lang.reflect.Field;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import com.buptcc.wechatapp.service.CreateCarpetPatternService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;

/**
 * @author: xgp
 * @date: 2019/1/17 10:36
 */
@Service
public class CreateCarpetPatternImp implements CreateCarpetPatternService {
    @Override
    public String Combine(String  br, String c, String m){
        Mat res = combine(br, c, m);
        Date date = new Date();
        String s = "F:\\imagedata\\"+date+".png";
        Imgcodecs.imwrite(s,res);
        return s;
    }

    private Mat load(String path) {
        System.loadLibrary("opencv_java401.dll");
        Mat src = Imgcodecs.imread(path,-1);
        return src;
    }
    //将角与边叠加
    private Mat CornerPlusBrink(Mat corner, Mat brink){
        int[] b = new int[4];
        int k = 200; //第200行中第一个透明点
        int z;
        for (z = 0; z < 600; z++) {
            //System.out.println(data[index+j+2]);
            if((brink.get(k,z)[3]) == 0)
                break;
        }
        b[0] = z;
        for (z = 599; z >=0; z--) {
            //System.out.println(data[index+j+2]);
            if((brink.get(k,z)[3]) == 0)
                break;
        }
        b[1] = z;

        z = 300;
        for (k = 0; k < 400; k++) {
            if((brink.get(k,z)[3]) == 0)
                break;
        }
        b[2] = k;
        for (k = 399; k >= 0; k--) {
            if((brink.get(k,z)[3]) == 0)
                break;
        }
        b[3] = k;

        for(int i = 0; i < corner.rows(); i++){
            for (int j = 0; j < corner.cols(); j++) {
                brink.put(i+b[2],j+b[0],corner.get(i,j));
            }
        }

        for(int i = 0; i < corner.rows(); i++){
            for (int j = corner.cols()-1; j >= 0; j--) {
                brink.put(i+b[2],b[1]-j,corner.get(i,j));
            }
        }
        for(int i = 0; i < corner.rows(); i++){
            for (int j = corner.cols()-1; j >= 0; j--) {
                brink.put(b[3]-i,b[0]+j,corner.get(i,j));
            }
        }
        for(int i = 0; i < corner.rows(); i++){
            for (int j = corner.cols()-1; j >= 0; j--) {
                brink.put(b[3]-i,b[1]-j,corner.get(i,j));
            }
        }
        return brink;
    }
    // 将所有的图片叠加，medal：裁剪过的，other：角+边，[]b 边界
    private Mat plusAll(Mat medal, Mat other) {
        Mat res = new Mat(400, 600, 24);
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 600; j++) {
                double[] t = medal.get(i, j);
                if (t[3] != 0) {
                    res.put(i+50, j, t);
                }
            }
        }
        for (int i = 0; i < other.rows(); i++) {
            for (int j = 0; j < other.cols(); j++) {
                double[] t = other.get(i, j);
                if (t[3] != 0) {
                    res.put(i, j, t);
                }
            }
        }

        return res;
    }
    private Mat colorTrans(Mat m, Mat medal) {
        Map<Integer,double[]> map = new HashMap<>();//构建hashmap，避免重复计算
        Integer key;

        double[]val;
        double[] t = {255,255,255,0};
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                if(m.get(i,j)[3] == 0){
                    m.put(i,j,t);
                }
                else {
                    double[] temp = m.get(i,j);
                    key = (int)(temp[0]*1000+temp[1]*100+temp[2]*10+temp[3]);
                    int p=0,q=0;
                    if(map.get(key)==null) {
                        for (int x = 0; x < medal.rows(); x += 50) {
                            for (int k = 0; k < medal.cols(); k += 50) {
                                //计算欧式距离
                                double d1 = distance(temp, medal.get(x, k));
                                double d2 = distance(temp, medal.get(p, q));
                                if (d1 < d2) {
                                    p = x;
                                    q = k;
                                }
                            }
                        }
                        val = medal.get(p,q);
                        m.put(i, j, val);
                        map.put(key,val);
                    }
                    else
                    {
                        m.put(i, j, map.get(key));
                    }
                }
            }
        }

        return m;
    }
    private double distance(double[]a, double[] b){
        double d = 0;
        for (int i = 0; i < 4; i++) {
            d+= Math.pow((a[i]-b[i]),2);
        }
        return d;
    }
    private Mat combine(String br, String c,String m){
        Mat medal = load(m);
        Mat corner = colorTrans(load(c), medal);
        Mat brink = colorTrans(load(br), medal);
        Mat com = CornerPlusBrink(corner, brink);
        return plusAll(medal,com);
    }
}
