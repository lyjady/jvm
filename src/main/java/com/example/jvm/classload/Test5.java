package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/14 17:54
 * 接口初始化测试
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Parent5.thrad);
    }
}

interface Parent5 {

    Thread thrad = new Thread() {
        {
            System.out.println("Parent5.instance initializer");
        }
    };

}

class Child5 implements Parent5 {
    static int a = 6;
}