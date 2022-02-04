package com.tinet.lize.itheima_20;

import java.util.ArrayList;

/**
 * Stream流中中间操作:
 *      map:返回由给定函数应用于此流的因素的结果组成的流
 *      mapToInt：和map类似，不过返回的是IntStream，IntStream中有sum()方法
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        list.add("60");

        list.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);

        System.out.println("---------------------------");

        list.stream().map(Integer::parseInt).forEach(System.out::println);

        System.out.println("---------------------------");

        int sum = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);


    }
}
