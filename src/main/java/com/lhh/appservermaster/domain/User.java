package com.lhh.appservermaster.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhoto;
    private String userType;
    private String userPhone;
    private String userGender;
    private String userEmail;
    private Integer userReputation;
    private String userMoney;
    private String userAuthFile;
    private String regTime;


    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String userPhoto, String userType, String userPhone, String userGender, String userEmail, Integer userReputation, String userMoney, String userAuthFile, String regTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhoto = userPhoto;
        this.userType = userType;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userReputation = userReputation;
        this.userMoney = userMoney;
        this.userAuthFile = userAuthFile;
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userType='" + userType + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userReputation=" + userReputation +
                ", userMoney='" + userMoney + '\'' +
                ", userAuthFile='" + userAuthFile + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserReputation(Integer userReputation) {
        this.userReputation = userReputation;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney;
    }

    public void setUserAuthFile(String userAuthFile) {
        this.userAuthFile = userAuthFile;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Integer getUserReputation() {
        return userReputation;
    }

    public String getUserMoney() {
        return userMoney;
    }

    public String getUserAuthFile() {
        return userAuthFile;
    }

    public String getRegTime() {
        return regTime;
    }
}
