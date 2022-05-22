package com.tinet.lize01.itheima_20;

import java.util.ArrayList;

/**
 * Stream流中中间操作filter
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        System.out.println("=================");
        list.forEach(System.out::println);

        System.out.println("=================");
        list.stream().forEach(System.out::println);

        System.out.println("=================");
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
    }
}
