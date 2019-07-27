package com.example.jvm.classload;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Arrays;

/**
 * @author linyongjin
 * @date 2019/7/21 17:16
 */
@SuppressWarnings("all")
public class CustomClassLoader extends ClassLoader {

    private String path = System.getProperty("user.dir") + "/target/classes/";

    private String classSufixx = ".class";

    /**
     * 使用AppClassLoader作为父加载器
     */
    public CustomClassLoader() {
        super();
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 使用指定的ClassLoader作为父加载器
     *
     * @param classLoader
     */
    public CustomClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass <tt>loadClass</tt>} method after checking the
     * parent class loader for the requested class.  The default implementation
     * throws a <tt>ClassNotFoundException</tt>.
     * 得到类的class对象
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return The resulting <tt>Class</tt> object
     * @throws ClassNotFoundException If the class could not be found
     * @since 1.2
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("我被执行了");
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 获取类的字节数组数据
     *
     * @param className
     * @return
     */
    public byte[] loadClassData(String className) {
        className = className.replace(".", "/");
        InputStream inputStream = null;
        ByteArrayOutputStream byteOutputStream = null;
        byte[] data = null;

        try {
            inputStream = new FileInputStream(new File(path + className + classSufixx));
            byteOutputStream = new ByteArrayOutputStream();

            int len = 0;
            while (-1 != (len = inputStream.read())) {
                byteOutputStream.write(len);
            }

            data = byteOutputStream.toByteArray();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                byteOutputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader classLoader = new CustomClassLoader();
        classLoader.setPath("C:\\Users\\TQ\\Desktop\\Notes\\");
        Class<?> clazz = classLoader.loadClass("com.example.jvm.classload.Parent2");
        System.out.println("hasCode: " + clazz.hashCode());
        System.out.println("classLoader: " + clazz.getClassLoader());
        System.out.println("----------------------------------------------");

        classLoader = null;
        clazz = null;

        System.out.println("------------------------");


        System.gc();

        Thread.sleep(90000000000L);

//        CustomClassLoader classLoader2 = new CustomClassLoader(classLoader);
//        classLoader2.setPath("C:\\Users\\TQ\\Desktop\\Notes\\");
//        Class<?> clazz2 = classLoader2.loadClass("com.example.jvm.classload.Parent2");
//        System.out.println("hasCode: " + clazz2.hashCode());
//        System.out.println("classLoader: " + clazz2.getClassLoader());
//        System.out.println("----------------------------------------------");
//
//        CustomClassLoader classLoader3 = new CustomClassLoader();
//        classLoader3.setPath("C:\\Users\\TQ\\Desktop\\Notes\\");
//        Class<?> clazz3 = classLoader3.loadClass("com.example.jvm.classload.Parent2");
//        System.out.println("hasCode: " + clazz3.hashCode());
//        System.out.println("classLoader: " + clazz3.getClassLoader());
//        System.out.println("----------------------------------------------");
    }
}
