package com.tinet.lize01.itheima_05;

import com.tinet.lize01.itheima_03.Flyable;

/**
 * 总结：lambdaa表达式的省略模式
 *  1.参数类型可以省略，但是有多个参数的情况下，不能只省略一个
 *  2.如果参数有且仅有一个，那么小括号可以省略
 *  3.如果代码块的语句只有一条，可以省略大括号和分号，甚至是return
 * @author lize
 * @date 2022年02月02日 20:16
 */
public class AddableDemo {
    public static void main(String[] args) {
        useAddable((x,y)->{
            return x+y;
        });

        userFlyable((s)->{
            System.out.println(s);
        });

        //参数只有一个，可以省略小括号
        userFlyable(s->{
            System.out.println(s);
        });

        //如果代码块语句只有一条，可以省略大括号和分号
        userFlyable(s->System.out.println(s));
        //如果代码块语句只有一条，可以省略大括号和分号，如果有返回值，return也可以省略
        useAddable((x,y)->x+y);
    }

    private static void userFlyable(Flyable flyable){
        flyable.fly("风和日丽，晴空万里");
    }

    private static void useAddable(Addable addable){
        int sum = addable.add(10, 20);
        System.out.println(sum);
    }
}
