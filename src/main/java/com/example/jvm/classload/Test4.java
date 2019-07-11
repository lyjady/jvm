package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/11 22:21
 * 类的初始化执行顺序是从上到下,在初始化之前的连接阶段里通过准备阶段将静态属性赋值默认值。
 * SingleTon instance = SingleTon.getInstance();调用了类的静态方法,属于主动使用,初始化类SingleTon。
 * 根据从上到下的初始化顺序
 * 将a赋予指定的值(因为没有指定值,所以就是默认值0)
 * 实例化SingleTon执行构造方法。a++,b++。此时a已经被初始化之后加1等于1,但是b只是在准备阶段赋予了默认值0。因为初始化是按顺序执行,
 * 不会因为使用到b,但是b没有初始化,就先去初始化b。此时使用b的默认值0,加1之后等于1。此时a=1, b=1
 * 继续按顺序初始化.初始化b的时候,将指定的值赋给b,让b完成初始化。此时b=0
 */
public class Test4 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        System.out.println("a : " + SingleTon.a);
        System.out.println("b : " + SingleTon.b);
    }
}

class SingleTon {
    public static int a;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        a++;
        b++;
        System.out.println("a : " + SingleTon.a);
        System.out.println("b : " + SingleTon.b);
        System.out.println("SingleTon.SingleTon");
    }

    public static int b = 0;

    public static SingleTon getInstance() {
        return singleTon;
    }
}