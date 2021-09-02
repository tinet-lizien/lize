package com.tinet.lize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lize
 * @date 2021年09月02日 17:59
 */
public class Java8StreamTest4 {

    /**
     * 字符串的拼接
     */
    @Test
    public void test1(){
        List<String> myList = new ArrayList<>();
        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");

        String joinStr = myList.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(joinStr);

        joinStr = myList.stream().collect(Collectors.joining(","));
        System.out.println(joinStr);
    }

    /**
     * string定义字符串模板
     */
    @Test
    public void test2(){
        String str = String.format("%d_%s", 11, "22");
        System.out.println(str);
    }
}
