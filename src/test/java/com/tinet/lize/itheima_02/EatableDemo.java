package com.tinet.lize.itheima_02;

/**
 * @author lize
 * @date 2022年02月02日 19:58
 */
public class EatableDemo {
    public static void main(String[] args) {
        Eatable eatable = new EatableImpl();
        useEatable(eatable);

        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("一天一苹果，医生远离我");
            }
        });

        useEatable(()->{
            System.out.println("一天一苹果，医生远离我");
        });
    }
    private static void useEatable(Eatable eatable){
        eatable.eat();
    }
}
