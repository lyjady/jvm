package com.example.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @author LinYongJin
 * @date 2019/8/25 15:33
 */
public class Test4 {

    /**
     * 对于Java的每个实例方法(非static方法),其在编译之后所生成的字节码文件中,方法的参数数量都会比源代码中的数量多一.
     * 多得那个就是this,他位于方法参数的第一个位置处;这样就能在Java的实例方法中使用this来去访问当前对象的属性以及其他的方法.
     *
     * 这个操作是在编译期间完成的,既由Javac编译器在编译的时候将对this的访问转化成一个对普通实例方法参数的访问,接下来在运行期间,由JVM
     * 在调用实例放啊发的时候,自动向方法中传入this参数.所以,在实例方法的局部变量中,至少会有一个指向当前对象的局部变量.
     */
    /**
     * 异常处理:
     * 在class字节码中被捕获的异常信息都放在exception table中
     * start_pc、end_pc:表示从code数组中从start_pc开始到end_pc结束(不包含end_pc)的这段代码由哪个表项处理
     * handle_pc:表示处理异常的开始处
     * catch_pc:便是会被处理的异常类型,他指向常量池中的一个异常类.当catch_pc为0时表示处理所有的异常.
     *
     * 如果实在方法中抛出异常则不会在异常表中显示而是作为一个Attribute在指定的方法中名称是Exceptions
     *
     * 1.现版本中对异常的处理统一使用异常表的方式处理
     * 2.但是在jdk1.4.2之前的版本中,是采用特定的指令方式对异常进行处理
     * 3.当异常中有finally块是,JVM会将finally块放在每个catch后面.意思就是有多少个catch块就会有多少个finally块在字节码中.
     */
    public void test() throws NullPointerException{
        try {
            InputStream is = new FileInputStream("text.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
