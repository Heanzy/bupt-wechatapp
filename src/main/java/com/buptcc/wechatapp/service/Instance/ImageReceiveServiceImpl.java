package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CustomImageDAO;
import com.buptcc.wechatapp.domain.CustomImage;
import com.buptcc.wechatapp.service.ImageReceiveService;
import com.buptcc.wechatapp.utils.imageRename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class ImageReceiveServiceImpl implements ImageReceiveService {

    @Autowired
    CustomImageDAO customImageDAO;

    @Override
    public String saveImage(MultipartHttpServletRequest req) {
        MultipartFile file = req.getFile("file");
        String realPath = "/usr/webchatdata/data_custom/";
        CustomImage customImage = imageRename.buildCustomImage(req);
        customImageDAO.insert(customImage);
        try {
            File dir = new File(realPath);
            if(!dir.exists()){
                dir.mkdir();
            }
            File f = new File(realPath, customImage.getImageName());
            if (!Objects.isNull(file)) {
                file.transferTo(f);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return customImage.getImageName();
    }
}
