package com.buptcc.wechatapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.lang.reflect.Field;

@SpringBootApplication
@MapperScan("com.buptcc.wechatapp.dao")
public class AppserverMasterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(AppserverMasterApplication.class);
    }

    public static void main(String[] args) {
        //System.load("D:\\Program Files\\Java\\jre\\bin\\opencv_java345.dll");
        SpringApplication.run(AppserverMasterApplication.class, args);

    }
}
