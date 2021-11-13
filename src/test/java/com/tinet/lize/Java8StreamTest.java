package com.tinet.lize;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        String[] arr = new String[]{"jack", "tom", "aihua"};
        List<String> list2 = Arrays.asList(arr);
        if(list2.contains("jack")){
            System.out.println(true);
        }
        list2.stream().filter(a -> !"bb".equals(a)).collect(Collectors.toList()).forEach(System.out::println);

        List<Student> students = list2.stream().map(ss -> {
            Student student = new Student();
            student.setName(ss);
            return student;
        }).collect(Collectors.toList());
        System.out.println(students);

        Map<String, String> map = list2.stream().collect(Collectors.toMap(s -> s, s -> s + s));
        System.out.println(map);
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
    @Test
    public void f6() {

        String s = "{YYYY}{MM}{DD}{0000}";

//因为默认为贪婪模式,所以如果没有使用显示()组中的元素不能为大括号([^}]*),而是使用(.*),

//那么会匹配的字符串为:one}{two}{three

        Pattern p = Pattern.compile("\\{([^}]*)\\}");


        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println(m.group(1));//第一次匹配成功是one,第二次匹配成功是two,第三次匹配为three

        }



    }

    public boolean codeVerification(String code){
            return true;
    }

}
