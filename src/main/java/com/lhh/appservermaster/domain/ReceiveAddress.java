package com.lhh.appservermaster.domain;

import java.io.Serializable;

public class ReceiveAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer receiveId;
    private String receiveName;
    private String receivePhone;
    private String receiveState;

    public ReceiveAddress() {
    }

    public ReceiveAddress(Integer receiveId, String receiveName, String receivePhone, String receiveState) {
        this.receiveId = receiveId;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveState = receiveState;
    }


    @Override
    public String toString() {
        return "ReceiveAddress{" +
                "receiveId=" + receiveId +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", receiveState='" + receiveState + '\'' +
                '}';
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
}
