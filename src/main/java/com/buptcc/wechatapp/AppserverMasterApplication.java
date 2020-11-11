package com.buptcc.wechatapp;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

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
