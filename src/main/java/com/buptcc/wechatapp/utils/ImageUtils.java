package com.buptcc.wechatapp.utils;

import com.buptcc.wechatapp.domain.CustomImage;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/21 15:11
 */
public class ImageUtils {

    public static String name(String preName){
        int index=preName.lastIndexOf(".");
        String suffix=preName.substring(index);//获取后缀名
        return UUID.randomUUID().toString().replace("-","")+suffix;
    }

    public static String removeSuffix(String name){
        int index = name.indexOf(".");
        if (index != -1){
            return name.substring(0, name.indexOf("."));
        }
        return name;
    }

    public static CustomImage buildCustomImage(MultipartHttpServletRequest req) {
        String openId = req.getParameter("openId");
        int subjectType = Integer.parseInt(req.getParameter("subjectType"));
        int prodType = Integer.parseInt(req.getParameter("productionType"));
        int imageType = Integer.parseInt(req.getParameter("imageType"));
        String name = ImageUtils.name(req.getParameter("preName"));
        return new CustomImage(openId, subjectType, prodType, imageType, name);
    }


    public static void reSize(File srcImg, int width, int height, boolean equalScale) {

        if (width < 0 || height < 0) {
            return;
        }
        BufferedImage srcImage = null;
        try {
            srcImage = ImageIO.read(srcImg);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (srcImage != null) {
            // targetW，targetH分别表示目标长和宽
            BufferedImage target = null;
            double sx = (double) width / srcImage.getWidth();
            double sy = (double) height / srcImage.getHeight();
            // 等比缩放
            if (equalScale) {
                if (sx > sy) {
                    sx = sy;
                    width = (int) (sx * srcImage.getWidth());
                } else {
                    sy = sx;
                    height = (int) (sy * srcImage.getHeight());
                }
            }
            ColorModel cm = srcImage.getColorModel();
            WritableRaster raster;
            raster = cm.createCompatibleWritableRaster(width, height);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();

            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
            Graphics2D g = target.createGraphics();
            // smoother than exlax:
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.drawRenderedImage(srcImage, AffineTransform.getScaleInstance(sx, sy));
            g.dispose();
            // 将转换后的图片保存
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(target, "png", baos);
                FileOutputStream fos = new FileOutputStream(srcImg);
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean judgeCustomImage(String name) {
        return name.length() > 15;
    }

    public static String addSuffix(String name){
        if (name.length() >10 || name.endsWith(".png")){
            return name;
        }else {
            return name + ".png";
        }
    }
}