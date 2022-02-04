package com.tinet.lize.itheima_20;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Stream流中中间操作:
 *      <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b):合并流
 *      Stream<T> distinct()：去重
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        Stream<String> limitStream = list.stream().limit(4);

        Stream<String> skipStream = list.stream().skip(2);

        //Stream.concat(limitStream,skipStream).forEach(System.out::println);

        System.out.println("-----------------------");

        Stream.concat(limitStream,skipStream).distinct().forEach(System.out::println);

    }
}
