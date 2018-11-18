package com.xjtu.pic_gradient.test1;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 0:33 2018/11/18
 * @Modified By:
 */
public class JNITest {
    public native void testHello();

    public static void main(String[] args){

        System.loadLibrary("TestSSE");
        JNIDemo jniDemo = new JNIDemo();
        jniDemo.testHello();
    }
}
