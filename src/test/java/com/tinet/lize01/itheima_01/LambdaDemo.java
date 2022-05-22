package com.tinet.lize01.itheima_01;

/**
 * @author lize
 * @date 2022年02月02日 19:25
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //多线程类的方式实现需求
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //匿名内部类的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程程序启动了");
            }
        }).start();

        //Lambda表达式的方式
        new Thread(()->{
            System.out.println("多线程启动了");
        }).start();
    }
}
