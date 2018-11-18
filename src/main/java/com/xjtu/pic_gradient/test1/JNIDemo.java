package com.xjtu.pic_gradient.test1;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 20:45 2018/11/17
 * @Modified By:
 */
public class JNIDemo {

    public native void testHello();

    public static void main(String[] args){

        System.loadLibrary("TestJNI");
        JNIDemo jniDemo = new JNIDemo();
        jniDemo.testHello();
    }
}
