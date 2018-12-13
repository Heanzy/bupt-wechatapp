package com.lhh.appservermaster.domain;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer orderId;
    private String orderName;
    private Integer userId;
    private String expressCompanyName;
    private String expressCompanyAddress;
    private Integer receiveAddressId;
    private String addTime;
    private String orderState;
    private String orderPay;
    private String remark;
    private String receiveCode;
    private String userPhone;
    private String orderEvaluate;
    private Integer takeUserId;
    private String score;
    private String orderType;
    private String orderPic;

    // TODO 把地址的字段添加到订单
    private String receiveName;
    private String receivePhone;
    private String receiveState;
    private String receiveAddressName;

    public Order() {
    }

    public Order(Integer orderId, String orderName, Integer userId, String expressCompanyName, String expressCompanyAddress, Integer receiveAddressId, String addTime, String orderState, String orderPay, String remark, String receiveCode, String userPhone, String orderEvaluate, Integer takeUserId, String score, String orderType, String orderPic, String receiveName, String receivePhone, String receiveState, String receiveAddressName) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.userId = userId;
        this.expressCompanyName = expressCompanyName;
        this.expressCompanyAddress = expressCompanyAddress;
        this.receiveAddressId = receiveAddressId;
        this.addTime = addTime;
        this.orderState = orderState;
        this.orderPay = orderPay;
        this.remark = remark;
        this.receiveCode = receiveCode;
        this.userPhone = userPhone;
        this.orderEvaluate = orderEvaluate;
        this.takeUserId = takeUserId;
        this.score = score;
        this.orderType = orderType;
        this.orderPic = orderPic;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveState = receiveState;
        this.receiveAddressName = receiveAddressName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", userId=" + userId +
                ", expressCompanyName='" + expressCompanyName + '\'' +
                ", expressCompanyAddress='" + expressCompanyAddress + '\'' +
                ", receiveAddressId=" + receiveAddressId +
                ", addTime='" + addTime + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderPay='" + orderPay + '\'' +
                ", remark='" + remark + '\'' +
                ", receiveCode='" + receiveCode + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", orderEvaluate='" + orderEvaluate + '\'' +
                ", takeUserId=" + takeUserId +
                ", score='" + score + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderPic='" + orderPic + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveState='" + receiveState + '\'' +
                ", receiveAddressName='" + receiveAddressName + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    public String getExpressCompanyAddress() {
        return expressCompanyAddress;
    }

    public void setExpressCompanyAddress(String expressCompanyAddress) {
        this.expressCompanyAddress = expressCompanyAddress;
    }

    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOrderEvaluate() {
        return orderEvaluate;
    }

    public void setOrderEvaluate(String orderEvaluate) {
        this.orderEvaluate = orderEvaluate;
    }

    public Integer getTakeUserId() {
        return takeUserId;
    }

    public void setTakeUserId(Integer takeUserId) {
        this.takeUserId = takeUserId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderPic() {
        return orderPic;
    }

    public void setOrderPic(String orderPic) {
        this.orderPic = orderPic;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    public String getReceiveAddressName() {
        return receiveAddressName;
    }

    public void setReceiveAddressName(String receiveAddressName) {
        this.receiveAddressName = receiveAddressName;
    }
}
