package com.tinet.lize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author lize
 * @date 2021年07月29日 14:49
 */
public class LambdaTester {
    //*********************->的使用*********************
    @Test
    public void f1(){
        //方式1：有参数类型，大括号和return
        MathOperation mathOperation1 = (int a,int b) -> {return a + b;};
        System.out.println(mathOperation1.operation(2, 3));
        //方式2：有参数类型
        MathOperation mathOperation2 = (int a,int b) -> a + b;
        System.out.println(mathOperation2.operation(2, 3));
        //方式3：只有括号
        MathOperation mathOperation3 = (a,b) -> a + b;
        System.out.println(mathOperation3.operation(2, 3));

        //注意：1.lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
        // 2.lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        String aa = "";
        if(4%2 != 0){
            aa = "2";
        }else{
            aa = "3";
        }
        String finalAa = aa;
        GreetingService greetingService = a -> finalAa + a;
        System.out.println(greetingService.sayMessage("aa"));
    }
    interface MathOperation{
        int operation(int a,int b);
    }
    interface GreetingService {
        String sayMessage(String message);
    }

    @Test
    public void f2(){
        Student student1 = new Student(28,"lize");
        Student student2 = new Student(28,"lize");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.stream().forEach(System.out::println);
        BiFunction<Integer, String, Student> aNew = Student::new;
        System.out.println(aNew);

    }

    //*********************::的使用*********************

    static class Something {

        // constructor methods
        Something() {}

        Something(String something) {
            System.out.println(something);
        }

        // static methods
        static String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }

        // object methods
        String endWith(String s) {
            return String.valueOf(s.charAt(s.length()-1));
        }

        void endWith() {}
    }
    @FunctionalInterface
    interface IConvert<F, T> {
        T convert(F form);
    }

    @Test
    public void f3(){
        // static methods（静态方法）
        IConvert<String, String> convert = Something::startsWith;
        String converted = convert.convert("123");
        System.out.println(converted);
    }

    @Test
    public void f4(){
        // object methods（非静态方法）
        Something something = new Something();
        IConvert<String, String> converter = something::endWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    @Test
    public void f5(){
        // constructor methods(构造方法)
        IConvert<String, Something> convert = Something::new;
        Something something = convert.convert("constructors");
        System.out.println(something.endWith("223"));
        //System.out.println(something);
    }

}
