package com.lhh.appservermaster.domain;

import java.io.Serializable;

public class ReceiveAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer receiveId;
    private String receiveName;  // 收货人名字
    private String receivePhone;
    private String receiveState;
    private String receiveAddressName;
    // TODO 根据收货人名字返回地址列表
    public ReceiveAddress() {
    }

    public ReceiveAddress(Integer receiveId, String receiveName, String receivePhone, String receiveState, String receiveAddressName) {
        this.receiveId = receiveId;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveState = receiveState;
        this.receiveAddressName = receiveAddressName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public String getReceiveState() {
        return receiveState;
    }

    public String getReceiveAddressName() {
        return receiveAddressName;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    public void setReceiveAddressName(String receiveAddressName) {
        this.receiveAddressName = receiveAddressName;
    }

    @Override
    public String toString() {
        return "ReceiveAddress{" +
                "receiveId=" + receiveId +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveState='" + receiveState + '\'' +
                ", receiveAddressName='" + receiveAddressName + '\'' +
                '}';
    }
}
