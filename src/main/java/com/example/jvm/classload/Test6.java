package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/15 21:32
 */
public class Test6 {
    public static void main(String[] args) throws Exception{
//        Class clazz = Class.forName("java.lang.String");
//        System.out.println(clazz.getClassLoader());
//        System.out.println("-------------------------");
//        Class clazz2 = Class.forName("com.example.jvm.classload.Child5");
//        System.out.println(clazz2.getClassLoader());

//        System.out.println(Child6.a);
//        System.out.println("====================");
//        Child6.doSomeThing();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass("com.example.jvm.classload.Parent6");
        System.out.println("-----------------------------------------");
        Class.forName("com.example.jvm.classload.Parent6");
    }
}

class Parent6 {

    public static int a = 1;

    static {
        System.out.println("Parent6.static initializer");
    }

    public static void doSomeThing() {
        System.out.println("Parent6.doSomeThing");
    }
}

class Child6 extends Parent6{
    static {
        System.out.println("Child6.static initializer");
    }
}
