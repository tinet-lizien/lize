package com.tinet.lize01.itheima_13;

/**
 * 函数式接口作为方法的参数传递
 *
 * @author lize
 * @date 2022年02月03日 16:43
 */
public class RunnableDemo {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动了");
            }
        }).start();

        startThread(()-> System.out.println(Thread.currentThread().getName()+"线程启动了"));
    }

    public static void startThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
