package com.tinet.lize01.itheima_16;

import java.util.function.Predicate;

/**
 * @author lize
 * @date 2022年02月04日 11:17
 */
public class PredicateDemo2 {
    public static void main(String[] args) {

        boolean b = checkString("hello", s -> s.length() > 3, s -> s.length() > 8);
        System.out.println(b);
    }

    private static boolean checkString(String s, Predicate<String> predicate1, Predicate<String> predicate2){
//        boolean b1 = predicate1.test(s);
//        boolean b2 = predicate2.test(s);
//        return b1 && b2;

//        return predicate1.and(predicate2).test(s);
        return predicate1.or(predicate2).test(s);
    }
}
