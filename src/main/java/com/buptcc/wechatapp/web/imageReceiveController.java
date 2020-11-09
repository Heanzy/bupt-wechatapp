package com.buptcc.wechatapp.web;

import com.buptcc.wechatapp.service.ImageReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class imageReceiveController {

    @Autowired
    ImageReceiveService imageReceiveService;

    @PostMapping("/uploadImage")
    public String uploadImage(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        return imageReceiveService.saveImage(req);
    }
}