package com.tinet.lize.itheima_08;

/**
 * 接口中默认的方法（java8新增）
 *  default void show3(){}
 *
 * @author lize
 * @date 2022年02月03日 0:38
 */
public class MyInterfaceDemo {
    public static void main(String[] args) {
        MyInterface myInterface1 = new MyInterfaceImplOne();
        myInterface1.show3();

        MyInterface myInterface2 = new MyInterfaceImplTwo();
        myInterface2.show3();
    }
}
