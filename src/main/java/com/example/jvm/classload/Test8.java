package com.example.jvm.classload;

import org.junit.Test;

/**
 * @author linyongjin
 * @date 2019/7/27 19:34
 * Sample是由CustomClassLoader进行加载的,Simple是由AppClassLoader类加载器加载。
 * 根据子类能访问父类,父类不能访问子类的原则。Simple不能访问Sample。
 */
public class Test8 {
    public static void main(String[] args) throws Exception {
        CustomClassLoader loader = new CustomClassLoader();
        loader.setPath("C:/Users/TQ/Desktop/Notes/");
        Class<?> clazz = loader.loadClass("com.example.jvm.classload.Sample");
        System.out.println(clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
