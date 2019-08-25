package com.example.jvm.bytecode;

/**
 * @author LinYongJin
 * @date 2019/8/22 21:36
 */
public class Test3 {

    String str = "Welcome";

    private int a = 10;

    public static String name = "Tom";

    public Test3() {

    }

    public Test3(int a) {
        System.out.println("this is Test3 method");
    }

    static {
        System.out.println("Test3.static initializer");
    }

    static {
        System.out.println("Test3.static initializer2");
    }

    static {
        System.out.println("Test3.static initializer3");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Test3 test = new Test3();
        test.setStr("Hello World");
        test.setA(24);
    }
}
