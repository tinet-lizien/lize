package com.tinet.lize01.itheima_09;

public interface Inter {
    void show();

    default void method(){
        System.out.println("Inter 中默认的方法执行了");
    }

    public static void test(){
        System.out.println("Inter 中静态的方法执行了");
    }
}
