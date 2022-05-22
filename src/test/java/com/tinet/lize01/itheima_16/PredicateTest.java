package com.tinet.lize01.itheima_16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 * @author lize
 * @date 2022年02月04日 16:47
 */
public class PredicateTest {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30","柳岩,34","张曼玉,35","貂蝉,31","王祖贤,33"};

        List<String> list = myFilter(strArray, s -> s.split(",")[0].length() > 2, s -> Integer.parseInt(s.split(",")[1]) > 33);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> myFilter(String[] strArray, Predicate<String> pre1,Predicate<String> pre2){
        List<String> list =  new ArrayList<>();

        for (String s : strArray) {
            if(pre1.and(pre2).test(s)){
                list.add(s);
            }
        }
        return list;
    }
}
