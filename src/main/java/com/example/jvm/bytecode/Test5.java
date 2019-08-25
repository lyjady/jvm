package com.example.jvm.bytecode;

/**
 * @author LinYongJin
 * @date 2019/8/25 16:04
 *
 * 方法调用的助记符
 * 1.invokeinterface: 调用接口中的方法实际上实在运行期决定的
 * 2.invokestatic: 调用静态方法
 * 3.invokespecial: 调用自己的私有方法、构造方法与父类的方法
 * 4.invokevirtual: 调用虚方法,运行期动态查找的过程
 * 5.invokedynamic: 动态调用方法
 *
 * 静态解析的4中情况
 * 1.静态方法
 * 2.父类方法
 * 3.构造方法
 * 4.私有方法
 * 以上4类方法称之为非虚方法,他们是在类加载的时候就可以将符号引用直接转换为直接引用
 */
public class Test5 {

    public void test(Grandpa grandpa) {
        System.out.println("this is Grandpa");
    }

    public void test(Father father) {
        System.out.println("this is father");
    }

    public void test(Son son) {
        System.out.println("this is son");
    }

    /**
     * g1和g2的静态类型是Grandpa,但是g1的实际类型是Father,g2的实际类型是Son
     * 变量的静态类型是不会发生变化的,但是实际类型会发生变化(多态的体现).实际类型在运行期才能确定.
     * 方法重载是一种静态的行为在编译器就能完全确定,方法重写完全相反.
     */
    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Test5 test = new Test5();
        test.test(g1);
        test.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
