package com.lhh.appservermaster.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class Utils {
    private Utils(){}
    private static Utils utils = null;
    public static Utils getInstance(){
        utils = new Utils();
        return utils;
    }
    /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param path 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
     public String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = getUUID() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    private String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
