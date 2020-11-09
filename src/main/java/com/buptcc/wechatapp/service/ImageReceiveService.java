package com.buptcc.wechatapp.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

public interface ImageReceiveService {

    String saveImage(MultipartHttpServletRequest request) throws IOException;
}
