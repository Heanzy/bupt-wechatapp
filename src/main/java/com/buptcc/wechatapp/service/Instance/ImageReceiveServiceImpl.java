package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CustomImageDAO;
import com.buptcc.wechatapp.domain.CustomImage;
import com.buptcc.wechatapp.service.ImageReceiveService;
import com.buptcc.wechatapp.utils.imageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@Transactional
public class ImageReceiveServiceImpl implements ImageReceiveService {

    @Autowired
    CustomImageDAO customImageDAO;

    @Override
    public String saveImage(MultipartHttpServletRequest req) throws IOException {
        MultipartFile file = req.getFile("file");
//        String realPath = "/usr/webchatdata/data_custom/";
        String realPath = "F:/test/";
        CustomImage customImage = imageUtils.buildCustomImage(req);
        System.out.println(customImage.toString());
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdir();
        }
        File f = new File(realPath, customImage.getImageName());
        if (!Objects.isNull(file)) {
            file.transferTo(f);
        }
        customImageDAO.insert(customImage);
        return customImage.getImageName();
    }
}
