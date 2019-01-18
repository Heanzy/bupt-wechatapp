package com.buptcc.wechatapp.domain;

import org.springframework.stereotype.Component;

/**
 * @author: xgp
 * @date: 2019/1/17 15:21
 */
@Component
public class UserImage {
    private Integer userimageID;
    private String openId;
    private String imageName;
    public UserImage(){

    }
    public UserImage(Integer ID, String openId, String imageName) {
        this.userimageID = ID;
        this.openId = openId;
        this.imageName = imageName;
    }
    public Integer getID() {
        return userimageID;
    }

    public String getUserId() {
        return openId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setID(Integer ID) {
        this.userimageID = ID;
    }

    public void setUserId(String userId) {
        this.openId = userId;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
