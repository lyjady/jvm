package com.example.jvm.classload;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author LinYongJin
 * @date 2019/8/6 21:51
 */
public class Test11 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("mysql:jdbc://172.16.10.111:3306/coc_event", "cocEvent", "CocEvent@123");
    }
}
