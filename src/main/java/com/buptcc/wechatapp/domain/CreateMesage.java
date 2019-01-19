package com.buptcc.wechatapp.domain;

import org.springframework.stereotype.Component;

@Component
public class CreateMesage {
    private String rName;
    CreateMesage(){

    }
    CreateMesage(String rName){
        this.rName = rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrName() {
        return rName;
    }
}
