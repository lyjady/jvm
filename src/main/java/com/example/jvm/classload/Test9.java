package com.example.jvm.classload;


import java.lang.reflect.Method;

/**
 * @author linyongjin
 * @date 2019/7/27 20:28
 * loader1和loader2加载了Common并生成了对应的实例。在loader1和loader2的命名空间中有Common,但是loader1与loader2是兄弟关系
 * 他们的命名空间是不能相互访问的。为object1(loader1命名空间中clazz1生成的实例)设置成员变量object2(loader2命名空间中clazz2生成的实例)
 * 但是他们两个之间是不能相互访问的。并且是两个不同的class对象。需要类型转换,但是又不能访问就出现的classcastexception.
 */
public class Test9 {
    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader();
        CustomClassLoader loader2 = new CustomClassLoader();

        loader1.setPath("C:/Users/TQ/Desktop/Notes/");
        loader2.setPath("C:/Users/TQ/Desktop/Notes/");

        Class<?> clazz1 = loader1.loadClass("com.example.jvm.classload.Common");
        Class<?> clazz2 = loader2.loadClass("com.example.jvm.classload.Common");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getDeclaredMethod("setCommon", java.lang.Object.class);
        method.invoke(object1, object2);


    }
}
