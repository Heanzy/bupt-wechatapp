package com.buptcc.wechatapp.domain.query;

import java.io.Serializable;

/**
 * 封装多个条件对order表的查询
 */
public class OrderQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String orderName;
    private String receiveAddressId;
    private String orderPay;
    private String addTime;
    private String takeUserId;
    private String orderState;
    private String expressCompanyName;
    private String expressCompanyAddress;// 收货地址
    private String remark;
    private String receiveCode;
    private String userPhone;
    private String orderEvaluate;

    public OrderQuery() {
    }

    public OrderQuery(String userId, String orderName, String receiveAddressId, String orderPay, String addTime, String takeUserId, String orderState, String expressCompanyName, String expressCompanyAddress, String remark, String receiveCode, String userPhone, String orderEvaluate) {
        this.userId = userId;
        this.orderName = orderName;
        this.receiveAddressId = receiveAddressId;
        this.orderPay = orderPay;
        this.addTime = addTime;
        this.takeUserId = takeUserId;
        this.orderState = orderState;
        this.expressCompanyName = expressCompanyName;
        this.expressCompanyAddress = expressCompanyAddress;
        this.remark = remark;
        this.receiveCode = receiveCode;
        this.userPhone = userPhone;
        this.orderEvaluate = orderEvaluate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(String receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getTakeUserId() {
        return takeUserId;
    }

    public void setTakeUserId(String takeUserId) {
        this.takeUserId = takeUserId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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
}
