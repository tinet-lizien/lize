package com.tinet.lize01.itheima_16;

import java.util.function.Predicate;

/**
 * 函数式接口3：Predicate<String>
 *
 * @author lize
 * @date 2022年02月04日 11:17
 */
public class PredicateDemo1 {
    public static void main(String[] args) {

        boolean b1 = checkString("hello", s -> {
            return s.length() > 8;
        });
        System.out.println(b1);

        boolean b2 = checkString("helloworld", s->s.length() > 8);
        System.out.println(b2);
    }

    private static boolean checkString(String s, Predicate<String> predicate){
        //return predicate.test(s);
        return predicate.negate().test(s);
    }
}
