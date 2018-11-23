package com.lhh.appservermaster.domain.query;

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

    public OrderQuery() {
    }

    public OrderQuery(String userId, String orderName, String receiveAddressId, String orderPay, String addTime) {
        this.userId = userId;
        this.orderName = orderName;
        this.receiveAddressId = receiveAddressId;
        this.orderPay = orderPay;
        this.addTime = addTime;
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
}
