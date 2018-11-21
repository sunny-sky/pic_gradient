<h1 align="center">渐变相册</h1>

## 1. 摘要
&#160; &#160; &#160; &#160;渐变相册项目是根据“并行计算架构与模式”课程老师朱利的课堂作业要求，完成的一个JAVAweb结合C++的网页项目，根据作业要求，使用了SSE指令和多线程技术实现图片渐变效果。

## 2. 介绍
&#160; &#160; &#160; &#160;渐变相册项目是一个基于Springboot的JAVAweb项目，其主要功能是可实现两张图片之间渐变转换。计算过程使用SSE指令和多线程技术进行加速，该部分使用C++实现，并封装成dll动态链接库，通过JNI由项目调用。

&#160; &#160; &#160; &#160;项目涉及技术、工具有：Springboot、thymeleaf、JNI、SSE、多线程、Mybatis、MySQL、CSS3、Jquery、Bootstrap。

&#160; &#160; &#160; &#160;主要功能有：

- 通过相册名建立相册并上传2张图片，后台实现其计算和数据库储存；
- 可选择已有的相册展示图片渐变效果。

## 3. 具体实现

### 3.1 指令选用
&#160; &#160; &#160; &#160;参考[微软SSE相关文档](https://docs.microsoft.com/zh-cn/previous-versions/k87x524b%28v%3dvs.110%29),考虑到
使用复杂程度、程序复杂、计算速度等，决定选用[__m128i _mm_avg_epu8](https://docs.microsoft.com/zh-cn/previous-versions/8zwh554a%28v%3dvs.110%29)
指令，可以根据传入的参数一次计算16个8位整数。部分代码如下：

``` cpp
for (int i = 0; i < n; i++) {
    *pDest = _mm_avg_epu8(*p1, *p2);
    p1++;  
    p2++;  
    pDest++;  
}
```


### 3.2 多线程实现

### 3.3 生成dll动态库
&#160; &#160; &#160; &#160;通过JNI(Java Native Interface)相关技术生成并调用dll动态库，调用dll类如下：

``` java
public class JNITest {

    public native void myMain(String dir);

    public static void generateImg(String path) {
        System.loadLibrary("homework");
        JNITest jniTest = new JNITest();
        jniTest.myMain(path);
    }
}
```

调用generateImg(String path)方法即可完成计算过程，生成60余张图片。

### 3.4 网页后端实现
&#160; &#160; &#160; &#160;通过Springboot快速建立一个JAVAweb应用，
使用Mybatis进行数据持久化，相册相关数据存入MySQL中，以供前端展示。

### 3.5 网页前端实现
&#160; &#160; &#160; &#160;使用Springboot推荐的Thymeleaf模板，结合
JQuery、Bootstrap技术，构建前端网页，用以展示图片的渐变效果。

## 4. 总结
