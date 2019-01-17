package com.buptcc.wechatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ImageURLPatternConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // location
        // registry.addResourceHandler("/user-images/**").addResourceLocations("file:D:\\app-server\\user-images\\");
        // remote
        registry.addResourceHandler("/user-images/**").addResourceLocations("file:/home/app-server/user-images/");
        registry.addResourceHandler("/order-images/**").addResourceLocations("file:/home/app-server/order-images/");
        super.addResourceHandlers(registry);
    }

}
