package com.buptcc.wechatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Heanzy
 */
@Configuration
public class ImageURLPatternConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // location
        // registry.addResourceHandler("/user-images/**").addResourceLocations("file:D:\\app-server\\user-images\\");
        // remoterestults
        registry.addResourceHandler("mini/image_results/**").addResourceLocations("file:/usr/webchatdata/result/");
        registry.addResourceHandler("mini/image_resources/**").addResourceLocations("file:/usr/webchatdata/data/");
        super.addResourceHandlers(registry);
    }

}
