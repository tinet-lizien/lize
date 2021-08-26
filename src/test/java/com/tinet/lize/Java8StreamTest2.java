package com.tinet.lize;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 测试Stream
 * @author lize
 * @date 2021年06月20日 13:48
 */
public class Java8StreamTest2 {
    /**
     *
     */
    @Test
    public void test1() {
        //1.多个数据直接转Stream
        Stream<String> stream1 = Stream.of("aa", "bb", "cc");
        System.out.println(stream1);
        System.out.println(Arrays.toString(stream1.toArray(String[]::new)));


        //2.数组<==>Stream
        String[] strings = new String[]{"aa", "bb", "cc"};
        Stream<String> stream2 = Arrays.stream(strings);
        System.out.println(stream1);
        Object[] objects = stream2.toArray(String[]::new);
        System.out.println(Arrays.toString(objects));


        //3.List<==>stream
        List<String> strList = new ArrayList<>();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        Stream<String> stream3 = strList.stream();
        System.out.println(stream3);
        List<String> list = stream3.collect(Collectors.toList());
        System.out.println(list);

        //4.Set <==> Stream
        Set<String> strSet = new HashSet<>();
        strSet.add("aa");
        strSet.add("bb");
        strSet.add("cc");
        Stream<String> stream4 = strSet.stream();
        System.out.println(stream4);
        Set<String> set = stream4.collect(Collectors.toSet());
        System.out.println(set);

        //map <==> Stream
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");
        Stream stream5 = map.entrySet().stream();
        System.out.println(stream5);

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1,"11"));
        list1.add(new Student(2,"22"));
        list1.add(new Student(3,"33"));
        Stream<Student> stream = list1.stream();
        Map<Integer, String> collect1 = stream.collect(Collectors.toMap(Student::getAge, Student::getName));
        Map<Integer, String> collect2 = stream.collect(Collectors.toMap(s -> s.getAge(), s -> s.getName()));
        System.out.println(collect1);
        System.out.println(collect2);
    }

    @Test
    public void test2() throws FileNotFoundException {
        //of()
        Stream<String> stream1 = Stream.of("aa", "bb", "cc");
        stream1.forEach(System.out::println);
        System.out.println("==============================================");
        //iterate
        Stream<Integer> stream2 = Stream.iterate(1, x -> (x * 2)).limit(20);
        stream2.forEach(System.out::println);
        System.out.println("==============================================");
        //generate
        Stream<Double> stream3 = Stream.generate(Math::random).limit(20);
        stream3.forEach(System.out::println);
        System.out.println("==============================================");
        //BufferedReader.lines()
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\工作记录.txt"));
        Stream<String> stream4 = br.lines();
        stream4.forEach(System.out::println);
        System.out.println("==============================================");
        //Pattern.splitAsStream()
        Pattern pattern = Pattern.compile(",");
        Stream<String> stream5 = pattern.splitAsStream("aa,bb,cc,dd");
        stream5.forEach(System.out::println);
        System.out.println("==============================================");
        //数组传字符串（逗号分割）的几种方式
        //方式1
        List<String> stringList = Arrays.asList("aa", "bb", "cc");
        String joinStr = StringUtils.join(stringList, "|");
        System.out.println(joinStr);
        //方式2
        StringJoiner sj = new StringJoiner(",","start_","_end");
        stringList.forEach(e->sj.add(e));
        System.out.println(sj.toString());
    }

    @Test
    public void test3(){
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1,10).forEach(System.out::println);
        IntStream.rangeClosed(1,10).forEach(System.out::println);

        LongStream.of(new long[]{1l,2l,3l}).forEach(System.out::println);
    }


    @Test
    public void test4(){

        List<String> stringList = new ArrayList<>();
        stringList.add("AA");
        stringList.add("AA");
        stringList.add("BB");
        stringList.add("BB");
        stringList.add("BB");
        stringList.add("CC");
        stringList.add("CC");
        System.out.println(stringList);

        List<String> stringList1 = stringList.stream().distinct().collect(Collectors.toList());

        System.out.println(stringList1);

        stringList1.forEach(x->{
            System.out.println("1"+x);
        });
    }

    private static List<Apple> appleStore = new ArrayList();

    static{
        appleStore.add(new Apple(1,"red",10));
        appleStore.add(new Apple(2,"red",30));
        appleStore.add(new Apple(3,"red",50));

        appleStore.add(new Apple(4,"blue",20));
        appleStore.add(new Apple(5,"blue",40));
        appleStore.add(new Apple(6,"blue",60));

        appleStore.add(new Apple(7,"yellow",20));
        appleStore.add(new Apple(8,"yellow",20));
        appleStore.add(new Apple(9,"yellow",20));
    }

    /**
     * 根据眼色分组并获取每组的平均重量（非stream实现实现）
     */
    @Test
    public void test5(){
        //1.基于颜色分组
        Map<String,List<Apple>> mps = new HashMap();
        for (Apple apple : appleStore) {
            List<Apple> list = mps.computeIfAbsent(apple.getColor(), key -> new ArrayList<>());
            list.add(apple);
        }
        for (Map.Entry<String, List<Apple>> entry : mps.entrySet()) {
            int weight = 0;
            for (Apple apple : entry.getValue()) {
                weight += apple.getWeight();
            }
            System.out.println(String.format("颜色%s 平均重量%s",entry.getKey(),weight/entry.getValue().size()));
        }
    }
    /**
     * 根据眼色分组并获取每组的平均重量（stream实现）
     */
    @Test
    public void test6(){
        appleStore.stream()
                .collect(Collectors.groupingBy(a -> a.getColor(), Collectors.averagingInt(a->a.getWeight())))
                .forEach((k,v)-> System.out.println(k+":"+v));
    }

    @Test
    public void test7(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Lambda1");
            }
        }).start();

        new Thread(()-> System.out.println("Lambda2")).start();

        start(()-> System.out.println("hello"));

    }

    public static void start(myRun2 run2){
        new Thread(run2).start();
    }

    @FunctionalInterface
    public interface myRun2 extends Runnable{
        public default void run2(){}
        String toString();
        boolean equals(Object obj);
    }

    //1.流的生成 与不可重复使用
    public static void main(String[] args) {
        appleStore.stream()
                .filter(a -> a.getColor().equals("red"))
                .peek(a-> System.out.println(a.getWeight()))
                .toArray();
    }

}
