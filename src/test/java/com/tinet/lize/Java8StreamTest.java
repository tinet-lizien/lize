package com.tinet.lize;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author lize
 * @date 2021年05月31日 10:20
 */
public class Java8StreamTest {

    @Test
    public void f1(){
        List<String> list = Arrays.asList("jack", "tom", "aihua");
        list.stream().filter(line -> !"tom".equals(line)).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void f2(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void f3(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
    }

    @Test
    public void f4(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void f5(){
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }


}
