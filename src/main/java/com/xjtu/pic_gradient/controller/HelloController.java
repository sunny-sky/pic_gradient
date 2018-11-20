package com.xjtu.pic_gradient.controller;

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
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index2(@RequestParam(value = "name", defaultValue = "photo1") String name, Map<String, String> map) {
        map.put("albumName", name);
        return "/index";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("img1") MultipartFile multipartFile1,
                            @RequestParam("img2") MultipartFile multipartFile2,
                            @RequestParam("name") String name) throws IOException, InterruptedException {
        String path = "D:\\workspace\\idea\\pic_gradient\\src\\main\\resources\\static\\images\\" + name;
        System.out.println(path);
        SaveImg.saveImg(multipartFile1, path, "00.bmp");
        SaveImg.saveImg(multipartFile2, path, "64.bmp");
        while (!isExist(path)) {
            System.out.println("图片未保存");
        }
        System.out.println("保存成功");
        JNITest.generateImg(path);

        return "/index?name="+name;
    }

    private boolean isExist(String path) {
        File file1 = new File(path + "\\00.bmp");
        File file2 = new File(path + "\\64.bmp");
        return file1.exists() && file2.exists();
    }
}
