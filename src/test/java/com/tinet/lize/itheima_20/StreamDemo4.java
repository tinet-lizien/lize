package com.tinet.lize.itheima_20;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Stream流中中间操作:
 *      Stream<T> sorted():排序
 *      Stream<T> sorted(Comparator<? super T> comparator)：指定规则排序
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("lingqingxia");
        list.add("zhangmanyu");
        list.add("wangzuxian");
        list.add("liuyan");
        list.add("zhangmin");
        list.add("zhangwuji");

        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------");
        list.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);
        System.out.println("---------------------------");
        list.stream().sorted((s1,s2)->{
            int num1 = s1.length()-s2.length();
            int num2 = num1==0?s1.compareTo(s2):num1;
            return num2;
        }).forEach(System.out::println);
    }
}
