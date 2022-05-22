package com.tinet.lize01.itheima_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流的收集操作
 *      toList
 *      toSet
 *      toMap
 *
 * @author lize
 * @date 2022年02月04日 17:48
 */
public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        List<String> myList = list.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
        for (String s : myList) {
            System.out.println(s);
        }

        System.out.println("----------------------");

        Set<String> mySet = list.stream().filter(s -> s.length() == 3).collect(Collectors.toSet());
        for (String s : mySet) {
            System.out.println(s);
        }

        System.out.println("-----------------------");

        String[] strArray = {"林青霞,30","张曼玉,35","王祖贤,33","柳岩,25"};
        Map<String, String> myMap = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 30).collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
        System.out.println(myMap.toString());


    }
}
