package com.tinet.lize01.itheima_11;

/**
 * 方法引用符号: ：：
 *  推导和省略：如果使用了lambda，那么根绝“可推导可省略”的原则，无需指定参数类型，无需制定重载形式，他们都将被自动推导
 *            如果使用方法引用，也是同样可以根据上下文进行推导
 *            方法引用是lambda的孪生兄弟
 * @author lize
 * @date 2022年02月03日 10:11
 */
public class LambdaDemo {
    public static void main(String[] args) {
        usePrintable(s-> System.out.println(s));

        //可推导的就是可引用的，把s作为参数给了println
        usePrintable(System.out::println);

        //引用静态方法
        useConverter(Integer::parseInt);

        //引用对象的实例方法
        usePrinter(s-> System.out.println(s.toUpperCase()));
        usePrinter(new PrintString()::printUpper);

        //引用类的实例方法：
        //lambda表达式被类的实例方法替代的时候
        //第一个所谓调用者
        //后面的参数全部传递给方法作为参数
        useMyString((s,x,y)->s.substring(x,y));
        useMyString(String::substring);

        //引用构造器
        //lambda表达式被构造器替代的时候，他的形式参数全部传递给构造器作为参数
        useStudentBuilder((String name,Integer age)->new Student("lize",29));
        useStudentBuilder(Student::new);

    }

    private static void usePrintable(Printable printable){
        printable.printString("爱生活爱Java");
    }

    private static void useConverter(Converter converter){
        int i = converter.contert("666");
        System.out.println(i);
    }

    private static void usePrinter(Printer printer){
        printer.printUpper("HelloWorld");
    }

    private static void useMyString(MyString myString){
        String subStr = myString.mySubString("HelloWorld", 2, 5);
        System.out.println(subStr);
    }

    private static void useStudentBuilder(StudentBuilder studentBuilder){
        Student lize = studentBuilder.build("lize", 29);
        System.out.println(lize.getName()+"--"+lize.getAge());
    }
}
