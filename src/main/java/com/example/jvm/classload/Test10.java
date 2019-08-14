package com.example.jvm.classload;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author LinYongJin
 * @date 2019/8/6 21:16
 */
public class Test10 {
    public static void main(String[] args) {
        //将线程上下文类加载器换成扩展类加载器
//        Thread.currentThread().setContextClassLoader(Test10.class.getClassLoader().getParent());

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println("===========");
            System.out.println(next.getClass() + "ClassLoader:" + next.getClass().getClassLoader());
            System.out.println("===========");
        }
        System.out.println("线程上下文类加载: " + Thread.currentThread().getContextClassLoader());
        System.out.println("加载ServiceLoader的类加载器: " + serviceLoader.getClass().getClassLoader());
    }
}
