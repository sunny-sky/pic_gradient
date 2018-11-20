package com.xjtu.pic_gradient.Utile;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 11:21 2018/11/20
 * @Modified By:
 */
public class SaveImg {
    public static String saveImg(MultipartFile multipartFile, String path, String name) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = name;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
