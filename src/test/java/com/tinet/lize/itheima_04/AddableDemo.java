package com.tinet.lize.itheima_04;

/**
 * @author lize
 * @date 2022年02月02日 20:16
 */
public class AddableDemo {
    public static void main(String[] args) {
        useAddable((int x,int y)->{
            return x+y;
        });
    }

    private static void useAddable(Addable addable){
        int sum = addable.add(10, 20);
        System.out.println(sum);
    }
}
