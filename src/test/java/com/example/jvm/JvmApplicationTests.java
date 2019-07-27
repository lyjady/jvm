package com.example.jvm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.PartialResultException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JvmApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(System.getProperty("user.dir"));
    }

}
