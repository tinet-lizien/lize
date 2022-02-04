package com.tinet.lize.itheima_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 函数式接口作为方法的返回值
 *
 * @author lize
 * @date 2022年02月03日 17:04
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("ccccc");
        array.add("aaaa");
        array.add("ddd");
        array.add("bb");
        array.add("e");
        System.out.println(array.toString());
        Collections.sort(array);
        System.out.println(array.toString());
        Collections.sort(array,getComparator());
        System.out.println(array.toString());
    }

    public static Comparator<String> getComparator(){
        //方式1
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };*/
        //方式2
//        return (String s1,String s2)->{return s1.length()-s2.length();};
        //方式3
          return (s1,s2)->s1.length()-s2.length();
    }
}
