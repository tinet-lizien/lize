package com.tinet.lize01.itheima_12;

/**
 * 函数式接口：有且仅有一个抽象方法的接口
 *    如何确认是否是函数式接口：加注解 @FunctionalInterface
 * @author lize
 * @date 2022年02月03日 13:33
 */
public class MyInterfaceDemo {
    public static void main(String[] args) {
         MyInterface myInterface = () -> System.out.println("函数式接口");
        myInterface.show();
    }
}
