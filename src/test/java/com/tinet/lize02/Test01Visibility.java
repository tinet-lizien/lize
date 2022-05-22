package com.tinet.lize02;

/**
 * @author lize
 * @date 2022年04月24日 0:12
 */
public class Test01Visibility {
    private static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (run){

            }
        });

        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() -> {
            run = false;
            System.out.println("时间到，线程2设置为false");
        });
        t2.start();
    }
}
