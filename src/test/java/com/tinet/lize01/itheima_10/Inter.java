package com.tinet.lize01.itheima_10;

public interface Inter {
    default void show1(){
        System.out.println("show1 开始执行");
//        System.out.println("初级程序员");
//        System.out.println("中级程序员");
//        System.out.println("高级程序员");
        show();
        System.out.println("show1 开始结束");
    }

    default void show2(){
        System.out.println("show2 开始执行");
//        System.out.println("初级程序员");
//        System.out.println("中级程序员");
//        System.out.println("高级程序员");
        show();
        System.out.println("show2 开始结束");
    }

    default void show(){
        System.out.println("初级程序员");
        System.out.println("中级程序员");
        System.out.println("高级程序员");
    }

    static void method1(){
        System.out.println("method1 开始执行");
//        System.out.println("初级程序员");
//        System.out.println("中级程序员");
//        System.out.println("高级程序员");
        method3();
        System.out.println("method1 开始结束");
    }

    static void method2(){
        System.out.println("method2 开始执行");
//        System.out.println("初级程序员");
//        System.out.println("中级程序员");
//        System.out.println("高级程序员");
        method3();
        System.out.println("method2 开始结束");
    }

    static void method3(){
        System.out.println("初级程序员");
        System.out.println("中级程序员");
        System.out.println("高级程序员");
    }
}
