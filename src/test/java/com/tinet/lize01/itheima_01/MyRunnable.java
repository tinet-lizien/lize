package com.tinet.lize01.itheima_01;

/**
 * @author lize
 * @date 2022年02月02日 19:26
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("多线程启动了");
    }
}
