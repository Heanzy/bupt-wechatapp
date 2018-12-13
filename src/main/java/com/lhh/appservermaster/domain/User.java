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
    private String nickName; // 昵称
    private Integer studentId; // 学号

    private String userAuthState;
    // TODO 添加字段payPwd
    private String payPwd;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String userPhoto, String userType, String userPhone, String userGender, String userEmail, Integer userReputation, String userMoney, String userAuthFile, String regTime, String nickName, Integer studentId, String userAuthState, String payPwd) {
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
        this.nickName = nickName;
        this.studentId = studentId;
        this.userAuthState = userAuthState;
        this.payPwd = payPwd;
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
                ", nickName='" + nickName + '\'' +
                ", studentId=" + studentId +
                ", userAuthState='" + userAuthState + '\'' +
                ", payPwd='" + payPwd + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserReputation() {
        return userReputation;
    }

    public void setUserReputation(Integer userReputation) {
        this.userReputation = userReputation;
    }

    public String getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserAuthFile() {
        return userAuthFile;
    }

    public void setUserAuthFile(String userAuthFile) {
        this.userAuthFile = userAuthFile;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getUserAuthState() {
        return userAuthState;
    }

    public void setUserAuthState(String userAuthState) {
        this.userAuthState = userAuthState;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }
}