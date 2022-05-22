package com.tinet.lize01.itheima_19;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流的常见的生成方式
 *      1.Collection体系的集合可以使用默认的方式stream()生成流
 *          default Stream<E> stream()
 *      2.Map体系间接生成流
 *      3.数组可以通过Stream接口的静态方法of(T...values)生成流
 *
 * @author lize
 * @date 2022年02月04日 17:59
 */
public class StreamDemo {
    public static void main(String[] args) {
        //1.Collection体系的集合可以使用默认的方式stream()生成流
        List<String> list = new ArrayList<>();
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        //2.Map体系间接生成流
        HashMap<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        //3.数组可以通过Stream接口的静态方法of(T...values)生成流
        String[] strArray = {"hello","world","java"};
        Stream<String> strArrayStream = Stream.of(strArray);
        Stream<String> stringStream = Stream.of("11", "22", "33");
        Stream<Integer> integerStream = Stream.of(11, 22, 33);
    }
}
