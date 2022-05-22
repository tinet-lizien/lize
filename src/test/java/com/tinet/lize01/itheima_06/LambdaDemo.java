package com.tinet.lize01.itheima_06;

/**
 * lambda表达式的注意事项：
 * 1.使用lambda表达式必须要有接口，并且要求接口中有且仅有一个抽象方法
 * 2.必须要有上下文环境，才能推导出lambda表达式对应的接口
 *  根据 局部变量的赋值 得知lambda表达式对应的接口：Runnable r = ()-> System.out.println("Lambda表达式");
 *  根绝 调用方法的参数 得知lambda表达式对应的接口：new Thread(()->System.out.println("Lambda表达式")).start();
 * @author lize
 * @date 2022年02月02日 20:44
 */
public class LambdaDemo {
    public static void main(String[] args) {
        useInter(()->{
            System.out.println("好好学习，天天向上");
        });
        //使用lambda表达式必须要有接口，并且要求接口中有且只有一个抽象方法
        useInter(()->System.out.println("好好学习，天天向上"));

        //必须要有上下文环境，才能推导出lambda对应的接口
        Runnable r = ()-> System.out.println("Lambda表达式");
        new Thread(r).start();

        new Thread(()->System.out.println("Lambda表达式")).start();
    }
    private static void useInter(Inter inter){
        inter.show();
    }
}
