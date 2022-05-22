package com.tinet.lize01;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

        for (int i = 0; i <= strings.size()-1; i++) {
            System.out.println(strings.get(i));
        }

        for (String s : strings){
            System.out.println(s);
        }

        strings.forEach(s -> printValur(s));

        Consumer<String> consumer = Java8StreamTest5::printValur;
        strings.forEach(s -> consumer.accept(s));

        strings.forEach(System.out::println);

        strings.forEach(s -> System.out.println("print value:" + s));
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

    @Test
    public void test3(){
        Student s1 = new Student(21,"lize1");
        Student s2 = new Student(21,"lize2");
        Student s3 = new Student(22,"lize3");
        Student s4 = new Student(22,"lize4");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        List<StudentCopy> collect = list.stream().map(s -> {
            StudentCopy sc = new StudentCopy();
            BeanUtils.copyProperties(s,sc);
            return sc;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test4(){

        Student s1 = new Student(21,"lize1");
        Student s2 = new Student(22,"lize2");
        Student s3 = new Student(23,"lize3");
        Student s4 = new Student(24,"lize4");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Integer[] integers = list.stream().map(Student::getAge).distinct().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));

        Map<Integer, Student> collect = list.stream().collect(Collectors.toMap(c -> c.getAge(), c -> c));
        System.out.println(collect);


    }
}
