package com.buptcc.wechatapp.service;

import java.util.List;
import java.util.Map;

public interface UserCustomImageService {

    Map<String, List<List<String>>> getUserCustomImage(String openId, int subjectType);

    public boolean deleteCustom(String openId, String name);
}
