package com.tinet.lize01.itheima_20;

import java.util.ArrayList;

/**
 * Stream流中的终结操作:
 *      void forEach():遍历
 *      long count()：返回元素个数
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        list.stream().forEach(System.out::println);

        System.out.println("-------------------");

        long count = list.stream().count();
        System.out.println(count);

    }
}
