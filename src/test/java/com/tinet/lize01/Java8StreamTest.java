package com.tinet.lize01;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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

    public boolean validateRule (String rule){
        //1.限制规则位数为35位
        if (rule.length() > 35){
            return false;
        }
        //2.校验里面是否含有{1-10位数字0}
        Pattern p = Pattern.compile("\\{(0{1,10})\\}");
        Matcher m = p.matcher(rule);
        if(!m.find()){
            return false;
        }
        //3.校验不含a-zA-Z0-9,_和-的其他字符
        String str = m.replaceAll("")
                .replaceAll("\\{YYYY\\}", "")
                .replaceAll("\\{MM\\}", "")
                .replaceAll("\\{DD\\}", "")
                .replaceAll("-", "")
                .replaceAll("_", "");

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher match = pattern.matcher(str);
        if(!match.matches()){
            return false;
        }
        return true;
    }

    public String convertToCustomId (String rule,int id){
        if (StringUtils.isBlank(rule)){
            return String.valueOf(id);
        }
        Pattern p = Pattern.compile("\\{(0{1,10})\\}");
        Matcher m = p.matcher(rule);
        while (m.find()) {
            String str = String.format("%0"+m.group(1).length()+"d", id);
            rule = rule.replace("{"+m.group(1)+"}",str);
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        rule = rule.replaceAll("\\{YYYY\\}",String.valueOf(year));
        rule = rule.replaceAll("\\{MM\\}",String.valueOf(month));
        rule = rule.replaceAll("\\{DD\\}",String.valueOf(date));
        return rule;
    }

    @Test
    public void f9(){

        String ruleStr = "SL{0}SL{0}{YYYY}{MM}{DD}";
        System.out.println(validateRule(ruleStr));
        if(validateRule(ruleStr)){
            System.out.println(convertToCustomId(ruleStr,1234));
        }
    }

}
