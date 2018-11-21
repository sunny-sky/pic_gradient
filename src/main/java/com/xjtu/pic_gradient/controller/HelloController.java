package com.xjtu.pic_gradient.controller;


import com.xjtu.pic_gradient.mapper.PhotoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjtu.pic_gradient.Utile.SaveImg;
import com.xjtu.pic_gradient.test1.JNITest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan(value="com.xjtu.pic_gradient.mapper")
public class HelloController {
    @Autowired
    private PhotoMapper photoMapper;
    @RequestMapping("/index")
    public String index2(@RequestParam(value = "name", defaultValue = "photo1") String name, Map<String, Object> map) {

        List<String> photoNames = photoMapper.getName();
        map.put("albumName", name);
        map.put("photoNames",photoNames);
        System.out.println(photoNames.toString());
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "name") String name, Map<String, Object> map) {
        photoMapper.deleteName(name);
        List<String> photoNames = photoMapper.getName();
        String albumName = photoNames.get(0);
        map.put("albumName", albumName);
        map.put("photoNames",photoNames);
        System.out.println(photoNames.toString());
        return "index";
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return photoMapper.getPhotoName(1);
    }


    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("img1") MultipartFile multipartFile1,
                            @RequestParam("img2") MultipartFile multipartFile2,
                            @RequestParam("name") String name) throws IOException, InterruptedException {
        String path = "E:\\IDEA\\IntelliJ IDEA 2018.2\\workspace\\pic_gradient\\src\\main\\resources\\static\\images\\" + name;
        System.out.println(path);

        photoMapper.insertPhotoName(name);
        System.out.println("插入成功！");

        SaveImg.saveImg(multipartFile1, path, "00.bmp");
        SaveImg.saveImg(multipartFile2, path, "64.bmp");
        while (!isExist(path)) {
            System.out.println("图片未保存");
        }
        System.out.println("保存成功");
        JNITest.generateImg(path);

        return "redirect:index?name="+name;
    }

    private boolean isExist(String path) {
        File file1 = new File(path + "\\00.bmp");
        File file2 = new File(path + "\\64.bmp");
        return file1.exists() && file2.exists();
    }

//    @PostMapping("/uploadImg")
//    public String uploadImg(@RequestParam("img1") MultipartFile multipartFile1,
//                            @RequestParam("img2") MultipartFile multipartFile2,
//                            @RequestParam("name") String name) throws IOException, InterruptedException {
//        /*String path = "D:\\workspace\\idea\\pic_gradient\\src\\main\\resources\\static\\images\\" + name;*/
//        String path = "E:\\IDEA\\IntelliJ IDEA 2018.2\\workspace\\pic_gradient\\src\\main\\resources\\static\\images\\"+name;
//        System.out.println(path);
//
//        photoMapper.insertPhotoName(name);
//        System.out.println("插入成功！");
//
//        SaveImg.saveImg(multipartFile1, path, "00.bmp");
//        SaveImg.saveImg(multipartFile2, path, "64.bmp");
//        while (!isExist(path)) {
//            System.out.println("图片未保存");
//        }
//        System.out.println("保存成功");
//
//        JNITest.generateImg(path);
//        return "redirect:index?name="+name;
//    }
//
//    private boolean isExist(String path) {
//        File file1 = new File(path + "\\00.bmp");
//        File file2 = new File(path + "\\64.bmp");
//        return file1.exists() && file2.exists();
//    }
}
