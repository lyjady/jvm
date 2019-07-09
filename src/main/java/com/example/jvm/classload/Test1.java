package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/9 22:04
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Child.str);
    }
}

/**
 * 此时没有对Child类进行初始化但是依旧会进行加载
 * 查看类是否被加载可以通过-XX:+TraceClassLoading查看
 * JVM中的参数有
 *  1.-XX:+<option>  添加选项
 *  2.-XX:-<option>  取消选项
 *  1.-XX:+<option>=value 将option的值赋为value
 */
class Parent {
    public static String str = "Hello World";

    static {
        System.out.println("Parent.static initializer");
    }
}

class Child extends Parent{
    public static String str2 = "Child's str";

    static {
        System.out.println("Child.static initializer");
    }
}
