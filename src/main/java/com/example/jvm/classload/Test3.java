package com.example.jvm.classload;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author linyongjin
 * @date 2019/7/11 21:50
 * 编译时常量与运行时常量
 * 虽然str2被final修饰是个常量,常量应该放在Test3的常量池内。不会对Child3初始化,但是结果是Child3和他的父类别初始化了。
 * 因为之前的常量是编译时常量,在编译阶段就知道常量具体的值,所以就放在调用方法所在类的常量池中。之后从常量池去,不会主动使用类,就不会初始化
 * 但是UUID在编译时并不知道具体的值是多少,只有在运行阶段代码真正执行了才知道具体的值。这就是运行时常量。所以在编译阶段,编译器无法识别常量的值
 * 就不把常量放入常量池中,当调用的时候也是从类中主动的调用属于主动使用,所以就对类和其父类进行初始化
 */

/**
 * 当一个类为成员实例化数组时,不会对那个类初始化。因为只是实例化一个数组并不是那个类。
 * 数组的类型是JVM在运行的时候自动创建的。
 * 如果数组的成员是自定的类型,则数据的类型是 [ + 类全限定路径名
 * 如果是基本数据结构则是 [ + 对应类型的首字母大写 (int 就是 [I char 就是 [C) boolean 是 [Z
 * 父类就是Object。
 * javaDoc经常将构成数组的元素称之为Component,实际上就是数组降低一个纬度之后的类型
 * 在class字节码文件中,将应用类型作为数组元素的数组用助记符anewarray来表示,意思是将创建一个应用类型的数组,并将其应用值压入栈顶
 * newarray:用基本数据类型创建数据,并将其应用值压入栈顶
 */
public class Test3 {
    public static void main(String[] args) {
//        System.out.println(Child3.str2);
        Parent3[] parent3s = new Parent3[10];
        System.out.println(parent3s.getClass());
        System.out.println(parent3s.getClass().getSuperclass());

        int[] ints = new int[10];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[10];
        System.out.println(chars.getClass());
        System.out.println(chars.getClass().getSuperclass());
    }
}

class Parent3 {
    public static final String str = "Hello World";

    static {
        System.out.println("Parent3.static initializer");
    }
}

class Child3 extends Parent3 {
    public static final String str2 = UUID.randomUUID().toString();

    static {
        System.out.println("Child3.static initializer");
    }
}