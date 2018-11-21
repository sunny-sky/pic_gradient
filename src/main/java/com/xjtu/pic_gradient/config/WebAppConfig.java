package com.xjtu.pic_gradient.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 13:21 2018/11/20
 * @Modified By:
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("10MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("20MB");
        return factory.createMultipartConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/images/**").addResourceLocations("file:E:\\IDEA\\IntelliJ IDEA 2018.2\\workspace\\pic_gradient\\src\\main\\resources\\static\\images\\");
        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\Users\\42238\\Desktop\\1\\images\\");
    }

}

