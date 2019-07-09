package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/9 22:04
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Child2.i);
    }
}

/**
 * 当静态变量被final修饰时,此时str在编译时会视为常量。会被放进调用该常量的方法所在类的常量池中
 * 当使用的时候直接从常量池中获取,此时就算删除该常量所在的类所生成的字节码文件也不会对结果产生影响因为该值是存在调用方法的类的常量池中的，
 * 所以不会从相应的类中取得该常量。所以就不存在调用改类的常量,就不是主动使用
 * 就不会对类进行初始化。(此时类也不会被加载)
 *  反编译结果(助记符):
 *  ldc 将int float String的常量推送到栈顶
 *  iconst_1 ~ iconst_5 如果常量是1到5的话则显示iconst_n也是推送到栈顶
 *  bipush 将单字节数常量(-128~127)推送到栈顶(byte)
 *  sipush 将短整型值常量(-32768~32767)推送到栈顶(short)
 *	变量则显示getstatic 因为变量是从类中获取而不是从常量池中获取
 */
class Parent2 {
    public static final String str = "Hello World";

    static {
        System.out.println("Parent.static initializer");
    }
}

class Child2 extends Parent2{
    public static final String str2 = "Child's str";

    public static short i = 47;

    static {
        System.out.println("Child.static initializer");
    }
}
