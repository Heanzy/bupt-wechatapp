package com.buptcc.wechatapp.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;

public interface ImageReceiveService {

    String saveImage(MultipartHttpServletRequest request);
}
