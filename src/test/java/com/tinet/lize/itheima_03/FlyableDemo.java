package com.tinet.lize.itheima_03;

/**
 * @author lize
 * @date 2022年02月02日 20:10
 */
public class FlyableDemo {
    public static void main(String[] args) {
        //匿名内部类
        userFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("飞机自驾游");
            }
        });

        //lambda表达式
        userFlyable((String s)->{
            System.out.println(s);
            System.out.println("飞机自驾游");
        });
    }
    private static void userFlyable(Flyable flyable){
        flyable.fly("风和日丽，晴空万里");
    }
}
