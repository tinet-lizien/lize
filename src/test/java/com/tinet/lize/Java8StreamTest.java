package com.tinet.lize;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author lize
 * @date 2021年05月31日 10:20
 */
public class Java8StreamTest {

    @Test
    public void f1(){
        List<String> list = Arrays.asList("jack", "tom", "aihua");
        list.stream().filter(line -> !"tom".equals(line)).collect(Collectors.toList()).forEach(System.out::println);

        String[] arr = new String[]{"jack", "tom", "aihua"};
        List<String> list2 = Arrays.asList(arr);
        if(list2.contains("jack")){
            System.out.println(true);
        }
        list2.stream().filter(a -> !"bb".equals(a)).collect(Collectors.toList()).forEach(System.out::println);

        List<Student> students = list2.stream().map(ss -> {
            Student student = new Student();
            student.setName(ss);
            return student;
        }).collect(Collectors.toList());
        System.out.println(students);

        Map<String, String> map = list2.stream().collect(Collectors.toMap(s -> s, s -> s + s));
        System.out.println(map);
    }

    @Test
    public void f2(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void f3(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
    }

    @Test
    public void f4(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void f5(){
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    @Test
    public void f6() {

        String s = "{YYYY}{MM}{DD}{0000}";

        Pattern p = Pattern.compile("\\{([^}]*)\\}");

        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println(m.group(1));//第一次匹配成功是one,第二次匹配成功是two,第三次匹配为three

        }

    }


    @Test
    public void f7() {
        int id = 123;
        String s = "{YYYY}{MM}{DD}{00000}";
        Pattern p = Pattern.compile("\\{(0{1,10})\\}");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group(1));
            String str = String.format("%0"+m.group(1).length()+"d", id);
            System.out.println(str);
            s = s.replace("{"+m.group(1)+"}",str);
        }
        System.out.println(s);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        s = s.replaceAll("\\{YYYY\\}",String.valueOf(year));
        s = s.replaceAll("\\{MM\\}",String.valueOf(month));
        s = s.replaceAll("\\{DD\\}",String.valueOf(date));
        System.out.println(s);
    }
    @Test
    public void f8() {

        String regex = "^[a-zA-Z0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher("612356032232223");
        System.out.println(match.matches());;

    }

    public boolean validateRule (String ruleStr){
        //1.校验里面是否含有{000}
        Pattern p = Pattern.compile("\\{(0{1,10})\\}");
        Matcher m = p.matcher(ruleStr);
        if(!m.find()){
            System.out.println("不含有{000}格式");
            return false;
        }
        //2.校验不含有其他字符
        String ss = m.replaceAll("")
                .replaceAll("\\{YYYY\\}", "")
                .replaceAll("\\{MM\\}", "")
                .replaceAll("\\{DD\\}", "")
                .replaceAll("-", "")
                .replaceAll("_", "");
        System.out.println(ss);

        String regex = "[a-zA-Z0-9]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(ss);
        if(!match.matches()){
            System.out.println("含有不该含有的字符");
            return false;
        }
        return true;
    }

    public String convertToCustomId (String ruleStr,int id){
        //String s = "{YYYY}{MM}{DD}{00000}";
        Pattern p = Pattern.compile("\\{(0{1,10})\\}");
        Matcher m = p.matcher(ruleStr);
        while (m.find()) {
            System.out.println(m.group(1));
            String str = String.format("%0"+m.group(1).length()+"d", id);
            System.out.println(str);
            ruleStr = ruleStr.replace("{"+m.group(1)+"}",str);
        }
        System.out.println(ruleStr);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        ruleStr = ruleStr.replaceAll("\\{YYYY\\}",String.valueOf(year));
        ruleStr = ruleStr.replaceAll("\\{MM\\}",String.valueOf(month));
        ruleStr = ruleStr.replaceAll("\\{DD\\}",String.valueOf(date));
        System.out.println(ruleStr);
        return "";
    }

    @Test
    public void f9(){

        String ruleStr = "SL{0000000}-&{YYYY}{MM}{DD}";
        if(validateRule(ruleStr)){
            System.out.println(convertToCustomId(ruleStr,1234));
        }
    }

}
