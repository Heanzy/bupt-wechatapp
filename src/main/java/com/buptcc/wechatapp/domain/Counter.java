package com.buptcc.wechatapp.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Counter {
    private final static int counterId = 4396;

    private int imageCounter;

    private long pv;

    private long un;


    Counter(){

    }
    public Counter(int imageCounter,long pv,long un){
        this.imageCounter = imageCounter;
        this.pv = pv;
        this.un = un;

    }
    public int getImageCounter() {
        return imageCounter;
    }

    public long getPv() {
        return pv;
    }

    public long getUn() {
        return un;
    }

    public void setImageCounter(int imageCounter) {
        this.imageCounter = imageCounter;
    }

    public void setPv(long pv) {
        this.pv = pv;
    }

    public void setUn(long un) {
        this.un = un;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "ImageCounter=" + imageCounter +
                ", pv='" + pv + '\'' +
                ", un='" + un + '\'' +
                '}';
    }

    public static int getCounterId() {
        return counterId;
    }
}
