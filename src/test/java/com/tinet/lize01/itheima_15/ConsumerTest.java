package com.tinet.lize01.itheima_15;

import java.util.function.Consumer;

/**
 * @author lize
 * @date 2022年02月03日 23:52
 */
public class ConsumerTest {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30","张曼玉,35","王祖贤,33"};
        operatorString(strArray,s-> System.out.println("姓名："+s.split(",")[0]),s-> System.out.println(",年龄："+s.split(",")[1]));
    }

    private static void operatorString(String[] strArray, Consumer<String> con1,Consumer<String> con2){
        for (String s : strArray) {
            con1.andThen(con2).accept(s);
        }
    }
}
