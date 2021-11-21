package com.tinet.lize;

import net.minidev.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author lize
 * @date 2021年11月21日 22:29
 */
public class Java8StreamTest5 {

    /**
     * java8 双冒汗的使用
     */
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        for (String s : strings){
            System.out.println(s);
        }

        strings.forEach(s -> printValur(s));

        Consumer<String> consumer = Java8StreamTest5::printValur;
        strings.forEach(s -> consumer.accept(s));
    }

    public static void printValur(String s){
        System.out.println("print value:" + s);
    }

    @Test
    public void test2() {
        List<String> strings = Arrays.asList("lize", "shenwenlu", "lijingjing", "liufuqiang");
        List<String> list = strings.stream().filter(s -> StringUtils.isNoneBlank(s)).collect(Collectors.toList());
        System.out.println(list.toString());

        list.forEach(System.out::println);

        strings.stream().map(s -> s + "aa").forEach(System.out::println);
        Map<String, String> map = strings.stream().collect(Collectors.toMap(s -> s + "a", s -> s + "b"));
        System.out.println(map);

        List<String> collect = strings.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect.toString());

        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);
        long count = random.ints().limit(5).count();
        System.out.println(count);
    }
}
