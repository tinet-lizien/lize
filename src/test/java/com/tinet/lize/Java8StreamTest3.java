package com.tinet.lize;

import org.junit.Test;

/**
 * @author lize
 * @date 2021年07月04日 13:14
 */
public class Java8StreamTest3 {

    @Test
    public void test1(){
        fun(() -> System.out.println("hello"));
    }

    public void fun(com.tinet.lize.MyInterface myInterface){

    }

}
