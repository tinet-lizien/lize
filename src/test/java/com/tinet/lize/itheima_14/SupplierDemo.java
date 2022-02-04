package com.tinet.lize.itheima_14;

import java.util.function.Supplier;

/**
 * 函数式接口1：Supplier<String>
 *     生产型接口
 *
 * @author lize
 * @date 2022年02月03日 21:37
 */
public class SupplierDemo {

    public static void main(String[] args) {
        String ss = getString(() -> "林青霞");
        System.out.println(ss);

        Integer i = getInteger(() -> 11);
        System.out.println(i);
    }

    private static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    private static Integer getInteger(Supplier<Integer> supplier){
        return supplier.get();
    }
}
