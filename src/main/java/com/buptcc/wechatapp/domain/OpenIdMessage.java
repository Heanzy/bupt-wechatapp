package com.buptcc.wechatapp.domain;

import org.springframework.stereotype.Component;

/**
 * @author Heanzy
 */
@Component
public class OpenIdMessage {
    private String openId;
    OpenIdMessage(){

    }
    OpenIdMessage(String openId){
        this.openId = openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

}
