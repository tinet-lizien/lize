package com.tinet.lize01;

/**
 * @author lize
 * @date 2021年07月04日 23:52
 */
public class SimpleLambda {
    public static void main(String[] args) {

        run(new Format() {
            @Override
            public String run(String name, int age) {
                return String.format("name:%s  age:%d",name,age);
            }
        });

        run((name,age)-> String.format("name:%s  age:%d",name,age));
    }

    public static void run(Format r){
        r.run("鲁班",18);
    }

    public interface Format{
        String run(String name,int age);
    }
}
