package com.tinet.lize01.itheima_20;

import java.util.ArrayList;

/**
 * Stream流中中间操作:
 *          Stream<T> limit(long maxSize):截取前指定个数的数据
 *          Stream<T> skip(long n):跳过指定个数的数据，返回剩余数据
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        list.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------------------");
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("-------------------------");
        list.stream().skip(2).limit(2).forEach(System.out::println);
        System.out.println("-------------------------");
        list.stream().limit(4).skip(2).forEach(System.out::println);

    }
}
