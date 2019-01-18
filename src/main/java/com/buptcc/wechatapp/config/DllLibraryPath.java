package com.buptcc.wechatapp.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
@Configuration
public class DllLibraryPath implements EnvironmentAware {
    public static String PREFIX_DLL_PATH;

    @Override
    public void setEnvironment(Environment environment) {

        PREFIX_DLL_PATH = environment.getProperty("OPENCV_DLL_PATH") ;
        System.out.println(PREFIX_DLL_PATH);
    }
}
