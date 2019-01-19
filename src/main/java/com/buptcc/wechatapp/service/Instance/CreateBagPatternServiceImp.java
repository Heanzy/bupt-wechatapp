package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.config.DllLibraryPath;
import com.buptcc.wechatapp.dao.CounterDao;
import com.buptcc.wechatapp.dao.UserImageDao;
import com.buptcc.wechatapp.domain.Counter;
import com.buptcc.wechatapp.domain.UserImage;
import com.buptcc.wechatapp.service.CreateBagPatternService;
import com.buptcc.wechatapp.utils.Lab2Rgb;
import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class CreateBagPatternServiceImp implements CreateBagPatternService {
    @Autowired
    CounterDao counterDao;
    @Autowired
    UserImageDao userImageDao;
    @Autowired
    UserImage userImage;
//    @Value("${opencv.dll.path}")
//    String fielpath;
    @Override
    public String createBagPattern(String openId, String pName, String cName) {
        BufferedImage bufferedImage = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
        long startTime=System.currentTimeMillis();
        try {
            MatFileReader matFileReaderTarget = new MatFileReader("F:/Mini/data/"+pName+".mat");
            MatFileReader matFileReaderColorSyle = new MatFileReader("F:/Mini/data/"+cName+".mat");
            MLArray mlArrayTarget = matFileReaderTarget.getMLArray("target_l");
            MLArray mlArrayColorStyle = matFileReaderColorSyle.getMLArray("color_lab");
            MLDouble targetML=(MLDouble)mlArrayTarget;//将MAT文件内容转成double类型,target文件的ls值
            MLDouble colorStyleML=(MLDouble)mlArrayColorStyle;
            double[][] target=(targetML.getArray());//将targetMAT文件内容转成double数组
            double[][] matrixC=(colorStyleML.getArray());//将colorMAT文件内容转成double数组
            double[][] ColorStyle = new double[matrixC.length][2];//colorMat文件的ab值
            double[][] ColorStyleLSP = new double[matrixC.length][2];//colorMat文件的ls值
            double[][] ColorStyleLS = new double[ColorStyleLSP.length][2];
            for (int i =0; i<ColorStyleLS.length;i++){
                ColorStyleLS[i][0] = ColorStyleLSP[ColorStyleLS.length-i-1][0];
                ColorStyleLS[i][1] = ColorStyleLSP[ColorStyleLS.length-i-1][1];

            }

            double[] TargetLuminance = new double[target.length];//targetMat文件明度值
            for(int i = 0;i<matrixC.length;i++){
                ColorStyle[i][0] = matrixC[i][2];
                ColorStyle[i][1] = matrixC[i][3];
                ColorStyleLS[i][0] = matrixC[i][0];
                ColorStyleLS[i][1] = matrixC[i][1];
            }//分别colorMat文件的 ls和ab值
            for(int j = 0;j < target.length ; j++){
                TargetLuminance[j] = target[j][0];
            }//分别targetMat文件ab值
            int [] BestMatch = BestMatch(ColorStyleLS,target);//计算最佳匹配
            double [][]Lab = ColorTransfer1(BestMatch,ColorStyle,TargetLuminance);//计算结果图lab值
            for(int i = 0; i < Lab.length;i++)
                Lab[i][0] = Lab[i][0]*100;//l值乘100

            double [][]RGB = LAB2RGB(Lab);
            for(int i = 0; i < RGB.length;i++){
                RGB[i][0] = Math.abs(RGB[i][0]);
                RGB[i][1] = Math.abs(RGB[i][1]);
                RGB[i][2] = Math.abs(RGB[i][2]);
            }
            int [] useToBufferedImage = doub2Integ(RGB);
            int count = 0;
            for(int i=0;i<bufferedImage.getHeight();i++)
                for(int j=0;j<bufferedImage.getWidth();j++){
                    bufferedImage.setRGB(i,j,useToBufferedImage[count]);
                    count++;
                }
//            Imgcodecs.imwrite("F:/Mini/result/"+pName+"-"+cName+"Result.jpg",mat2);

            long endTime=System.currentTimeMillis();
            System.out.println("运行时间："+(double)(endTime-startTime)/1000+"s");
            //更新计数表
        Counter counter = counterDao.getCounter(Counter.getCounterId());
        counter.setImageCounter(counter.getImageCounter()+1);
        counterDao.updateImageCounter(counter);

            //更新UserImage表
            userImage.setUserId(openId);
            userImage.setImageName(pName.substring(0,3)+String.format("%05d",counter.getImageCounter()));
            File file = new File("F:/Mini/result/"+userImage.getImageName()+".jpg");
            ImageIO.write(bufferedImage,"jpg",file);
            System.out.println("transfer2 OK");
            userImageDao.insertImage(userImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pName.substring(0,3));
        return userImage.getImageName();
    }
    public int [] BestMatch(double[][] ColorStyle, double[][] target){
        int [] result = new int[target.length];
        for(int i = 0;i < target.length; i++){
            double min = Double.MAX_VALUE;
            int index = -1;
            for(int j = 0;j < ColorStyle.length;j++){
                double sum = 0;
                sum = (0.5)*(ColorStyle[j][0]-target[i][0])*(ColorStyle[j][0]-target[i][0])+(0.5)*(ColorStyle[j][1]-target[i][1])*(ColorStyle[j][1]-target[i][1]);
                if(sum < min){
                    min = sum;
                    index = j;
                }
            }
            result[i] = index;
        }
        return result;
    }
    public double [][] ColorTransfer1(int BestMatch [],double[][] ColorStyle,double [] TargetLuminance){
        double result[][] = new double[TargetLuminance.length][3];
        for(int i = 0;i < TargetLuminance.length; i++ ){
            result[i][0] = TargetLuminance[i];
            result[i][1] = ColorStyle[BestMatch[i]][0];
            result[i][2] = ColorStyle[BestMatch[i]][1];
//                System.out.println(i);
        }
        System.out.println("colorTransfer1 OK");
        return result;
    }

    public double [][] LAB2RGB(double [][] LAB)
    {
        double [][] RGB = new double[LAB.length][3];
        for(int i=0;i<LAB.length;i++)
            RGB[i] = Lab2Rgb.LAB2RGB(LAB[i]);
        return RGB;
    }
    public int [] doub2Integ(double [][] RGB){
        int [] result = new int[RGB.length];
        for(int i= 0; i<RGB.length;i++){
            int r = (int)RGB[i][0];
            int g = (int)RGB[i][1];
            int b = (int)RGB[i][2];
            result[i] = (r<<16)|(g<<8)|(b);

        }
        return result;
    }
}
