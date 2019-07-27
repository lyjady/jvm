package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/27 19:30
 */
public class Simple {

    public Simple() {
        System.out.println("simple load by " + this.getClass().getClassLoader());
//        System.out.println(Sample.class);
    }
}
