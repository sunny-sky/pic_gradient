package com.xjtu.pic_gradient.test1;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 0:33 2018/11/18
 * @Modified By:
 */
public class JNITest {

    public native void myMain(String dir);

    public static void main(String[] args) {

        System.loadLibrary("homework");
        JNITest jniTest = new JNITest();
        jniTest.myMain("D:\\workspace\\idea\\pic_gradient\\src\\main\\resources\\static\\images\\photo1");
    }
}
