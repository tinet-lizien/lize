package com.tinet.lize.itheima_10;

/**
 * 接口中的私有方法（java9新增）
 * 注：
 *      *默认方法可以调用私有的静态方法和非静态方法
 *      *静态方法只能调用私有的静态方法
 * @author lize
 * @date 2022年02月03日 9:44
 */
public class InterDemo {
    public static void main(String[] args) {
        Inter inter = new InterImpl();
        inter.show1();
        System.out.println("----------");
        inter.show2();;
        System.out.println("----------");

        Inter.method1();
        System.out.println("----------");
        Inter.method2();
    }
}
