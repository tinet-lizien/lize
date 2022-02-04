package com.tinet.lize.itheima_15;

import java.util.function.Consumer;

/**
 * 函数式接口2：Consumer<String>
 *
 * @author lize
 * @date 2022年02月03日 22:49
 */
public class ConsumerDemo {
    public static void main(String[] args) {

        operatorString("林青霞",s -> System.out.println(s));

        operatorString("林青霞",s -> System.out.println(s),s -> System.out.println(s));
    }

    private static void operatorString(String name, Consumer<String> con){
        con.accept(name);
    }

    private static void operatorString(String name, Consumer<String> con1,Consumer<String> con2){
       /* con1.accept(name);
        con2.accept(name);*/
        con1.andThen(con2).accept(name);
    }
}
