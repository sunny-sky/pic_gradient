package com.xjtu.pic_gradient.controller;

import com.xjtu.pic_gradient.mapper.PhotoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@MapperScan(value="com.xjtu.pic_gradient.mapper")
public class HelloController {
    @Autowired
    PhotoMapper photoMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello () {
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return photoMapper.getPhotoName(1);
    }


}
