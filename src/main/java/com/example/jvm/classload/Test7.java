package com.example.jvm.classload;

import org.junit.Test;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author linyongjin
 * @date 2019/7/18 21:27
 * 获得classloader的方式
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        getResource();
    }

    public static void getLoader() {
        ClassLoader classLoader  = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }

    //加载资源
    public static void getResource() throws IOException {
        String resourcePath = "com/example/jvm/classload/Test7.class";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resource = classLoader.getResources(resourcePath);
        while (resource.hasMoreElements()) {
            System.out.println(resource.nextElement());
        }
    }

    /**
    * @author linyongjin
    * @param
    * @return void
    * @date 21:40 2019/7/18
    * 数据的类型不是ClassLoader加载class文件生成的,而是在Java运行期间生成的。
     * 如果数组成员的类型是应用类型的话,数组的类加载器就是加载成员的类加载器,如果数组的成员类型是基本数据类型的话,那类加载器就是null
    **/
    @Test
    public void arrayClass() {
        //String类由Bootstrap ClassLoader加载。所以该数组的ClassLoader也为根加载器
        String[] strings = new String[2];
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("--------------------");
        //Test7类由Application ClassLoader加载。所以该数组的ClassLoader也为应用加载器
        Test7[] test = new Test7[2];
        System.out.println(test.getClass());
        System.out.println(test.getClass().getClassLoader());
        System.out.println("--------------------");
        //int为基本数据类型,所以ClassLoader为空
        int[] ints = new int[2];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getClassLoader());
    }
}
