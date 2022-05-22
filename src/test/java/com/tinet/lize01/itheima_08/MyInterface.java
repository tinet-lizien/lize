package com.tinet.lize01.itheima_08;

public interface MyInterface {
    void show1();

    void show2();

    default void show3(){
        System.out.println("接口中默认方法");
    }
}
