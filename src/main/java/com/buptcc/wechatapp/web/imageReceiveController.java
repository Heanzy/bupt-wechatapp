package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.utils.imageRename;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
public class imageReceiveController {

    @PostMapping("/uploadImage")
    public String uploadImage(HttpServletRequest request, String preName){
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        String name = imageRename.name(preName);
        String realPath = "/usr/webchatdata/data_custom/";
        try {
            File dir = new File(realPath);
            if(!dir.exists()){
                dir.mkdir();
            }
            File f = new File(realPath, name);
            if (!Objects.isNull(file)) {
                file.transferTo(f);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }
}