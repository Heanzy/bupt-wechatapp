package com.buptcc.wechatapp.service.Instance;

import com.buptcc.wechatapp.service.UserOpenIdService;
import com.buptcc.wechatapp.utils.GetOpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserOpenIdServiceImp implements UserOpenIdService {
    private GetOpenIdUtil getOpenIdUtil;
    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Override
    public String getUserOpenId(String code) {
        return getOpenIdUtil.getopenid(appid,code,secret);
    }
}
