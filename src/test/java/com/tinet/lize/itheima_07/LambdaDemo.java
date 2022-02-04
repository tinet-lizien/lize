package com.tinet.lize.itheima_07;

/**
 * lambda表达式和匿名内部类的区别
 *  所属类别不同
 *      *匿名内部类可以是接口，抽象类，具体类
 *      *lambda表达式只能是接口
 *  使用限制不同
 *      *如果接口中只有一个抽象方法，可以使用lambda表达式，也可以使用匿名内部类
 *      *如果接口中多于一个抽象方法，只能是匿名内部类，而不能使用lambda表达式
 *  实现原理不同
 *      *匿名内部类编译之后，产生一个单独的.class字节码文件
 *      *lambda表达式编译之后，没有单独的.class 字节码文件，对应的字节码会在运行的时候动态生成
 * @author lize
 * @date 2022年02月02日 21:24
 */
public class LambdaDemo {
    public static void main(String[] args) {
        useStudent(new Student(){
            @Override
            public void study() {
                System.out.println("具体类");
            }
        });

        useInter(new Inter() {
            @Override
            public void show() {
                System.out.println("接口");
            }
        });

        useAnimal(new Animal() {
            @Override
            public void method() {
                System.out.println("抽象类");
            }
        });

        useInter(()-> System.out.println("接口"));
        //useAnimal(()-> System.out.println());//编译报错
        //useAnimal(()-> System.out.println(""));//编译报错
    }

    private static void useStudent(Student s){
        s.study();
    }

    public static void useInter(Inter inter){
        inter.show();
    }

    public static void useAnimal(Animal animal){
        animal.method();
    }
}
