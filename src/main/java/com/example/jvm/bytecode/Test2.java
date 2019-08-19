package com.example.jvm.bytecode;

import java.util.Date;

/**
 * @author LinYongJin
 * @date 2019/8/19 20:59
 */
public class Test2 {

    private int a = 1;

    private Object object;

    private static String name = "Test2";

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        test.setA(2);
        test.setObject(new Date());
    }

    /**
     * 用synchronized修饰实例方法
     * 在class字节码中使用synchronized关键词的话会有monitorenter和monitoreaxit但是修饰一个实例方法的时候不会有
     * 因为默认的入口就是方法开始的时候方法开始的时候,出口就是结束的时候.
     * monitorenter和monitorexit就默认在Code中
     */
    public synchronized void method() {
        System.out.println("Hello World");
    }

    /**
     * 为实例方法中的代码块的话monitorenter和monitorexit就会出现在Code中,因为synchronized有一个入口但是可以有两个出口
     * 此时字节码中有两个monitorexit出口,一个是程序的正常出口,一个是当程序出异常的时候的出口.这样能保证如果程序出了异常后面的
     * 线程能获得锁从而保证程序的正常运行.所以要在athrow抛出异常之前进行退出
     */
    public void method2() {
        synchronized (object) {
            System.out.println("Hello World");
        }
    }

    public synchronized static void staticMethod() {
        System.out.println("Hello World");
    }

    public static void staticMethod2() {
        synchronized (name) {
            System.out.println("Hello World");
        }
    }
}
