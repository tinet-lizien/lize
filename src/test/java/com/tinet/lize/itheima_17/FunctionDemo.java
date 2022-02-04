package com.tinet.lize.itheima_17;

import java.util.function.Function;

/**
 * @author lize
 * @date 2022年02月04日 17:30
 */
public class FunctionDemo {
    public static void main(String[] args) {
        convert("111",s->Integer.parseInt(s));

        convert(111,i->String.valueOf(i+1));

        convert("111",s->Integer.parseInt(s),i->String.valueOf(i+1));
    }

    private static void convert(String s, Function<String,Integer> fun){
        Integer i = fun.apply(s);
        System.out.println(i);
    }

    private static void convert(Integer i, Function<Integer,String> fun){
        String s = fun.apply(i);
        System.out.println(s);
    }

    private static void convert(String s, Function<String,Integer> fun1,Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }
}
