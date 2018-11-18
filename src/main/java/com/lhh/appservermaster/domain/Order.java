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
    private Integer receiveCode;
    private String userPhone;
    private String orderEvaluate;
    private Integer takeUserId;

    public Order() {
    }

    public Order(Integer orderId, String orderName, Integer userId, String expressCompanyName, String expressCompanyAddress, Integer receiveAddressId, String addTime, String orderState, String orderPay, String remark, Integer receiveCode, String userPhone, String orderEvaluate, Integer takeUserId) {
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
                ", orderPay=" + orderPay +
                ", remark='" + remark + '\'' +
                ", receiveCode=" + receiveCode +
                ", userPhone='" + userPhone + '\'' +
                ", orderEvaluate='" + orderEvaluate + '\'' +
                ", takeUserId=" + takeUserId +
                '}';
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    public void setExpressCompanyAddress(String expressCompanyAddress) {
        this.expressCompanyAddress = expressCompanyAddress;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setReceiveCode(Integer receiveCode) {
        this.receiveCode = receiveCode;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setOrderEvaluate(String orderEvaluate) {
        this.orderEvaluate = orderEvaluate;
    }

    public void setTakeUserId(Integer takeUserId) {
        this.takeUserId = takeUserId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    public String getExpressCompanyAddress() {
        return expressCompanyAddress;
    }

    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public String getRemark() {
        return remark;
    }

    public Integer getReceiveCode() {
        return receiveCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getOrderEvaluate() {
        return orderEvaluate;
    }

    public Integer getTakeUserId() {
        return takeUserId;
    }
}
