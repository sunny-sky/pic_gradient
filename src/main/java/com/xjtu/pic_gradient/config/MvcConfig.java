package com.xjtu.pic_gradient.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers (ViewControllerRegistry registry) {
        // 使/test指向test页面
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/photo").setViewName("photo");
    }


}
