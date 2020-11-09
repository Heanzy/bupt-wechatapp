package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.ImageReceiveService;
import com.buptcc.wechatapp.utils.imageRename;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ImageReceiveService imageReceiveService;

    @PostMapping("/uploadImage")
    public String uploadImage(HttpServletRequest request){
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        return imageReceiveService.saveImage(req);
    }
}