package com.tinet.lize01.itheima_09;

/**
 * 接口中的静态方法（java8新增）
 * 注：只能通过接口调用，实现接口的具体类无法调用（原因：因为如果实现类实现了两个接口，两个接口中有同样的静态方法，无法判断是调用的哪一个）
 *    public可以省略，static不能以省略
 * @author lize
 * @date 2022年02月03日 0:58
 */
public class InterDemo {
    public static void main(String[] args) {
        Inter inter = new InterImpl();
        inter.show();
        inter.method();
        Inter.test();
        Flayable.test();
    }
}
