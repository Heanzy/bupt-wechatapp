package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.dao.CustomImageDAO;
import com.buptcc.wechatapp.domain.CustomImage;
import com.buptcc.wechatapp.domain.CustomImageExample;
import com.buptcc.wechatapp.service.UserCustomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class UserCustomImageServiceImpl implements UserCustomImageService {

    @Autowired
    CustomImageDAO customImageDAO;

    @Override
    public Map<String, List<List<String>>> getUserCustomImage(String openId, int subjectType) {
        Map<String, List<List<String>>> map = new HashMap<>();
        String[] type = new String[]{"b", "c"};
        for (int i = 0; i < 2; i++) {
            List<List<String>> list = new ArrayList<>();
            for (int j = 0; j <= i+1; j++) {
                list.add(getImageName(openId, i, j, subjectType));
            }
            map.put(type[i], list);
        }
        return map;
    }

    private List<String> getImageName(String openId, Integer prodType, Integer imageType, Integer subjectType) {
        CustomImageExample example = new CustomImageExample();
        CustomImageExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        criteria.andSubjectTypeEqualTo(subjectType);
        criteria.andProductionTypeEqualTo(prodType);
        criteria.andImageTypeEqualTo(imageType);
        List<CustomImage> images = customImageDAO.selectByExample(example);
        return images.stream().map(CustomImage::getImageName).collect(Collectors.toList());
    }

    public boolean deleteCustom(String openId, String name){
        CustomImageExample example = new CustomImageExample();
        CustomImageExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        criteria.andImageNameEqualTo(name);
        return customImageDAO.deleteByExample(example) == 1;
    }
}
