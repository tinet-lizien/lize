package com.tinet.lize02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lize
 * @date 2022年04月24日 22:19
 */
public class Test2Atomicity {

    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
          for (int i = 0 ;i<1000;i++){
            number ++;
          }
        };

        List<Thread> ts = new ArrayList<>();
        for (int i=0;i<5;i++){
            Thread t = new Thread(increment);
            t.start();
            ts.add(t);
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println("number = " + number );
    }
}
