package com.example.jvm.classload;

/**
 * @author linyongjin
 * @date 2019/7/27 19:29
 */
public class Sample {

    private Sample sample;

    public Sample() {
        System.out.println("Sample load by " + this.getClass().getClassLoader());
        new Simple();
        System.out.println(Simple.class);
    }

    public void setSample(Object sample) {
        this.sample = (Sample) sample;
    }
}
