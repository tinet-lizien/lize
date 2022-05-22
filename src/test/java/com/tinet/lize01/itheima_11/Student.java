package com.tinet.lize01.itheima_11;

import lombok.Data;

/**
 * @author lize
 * @date 2022年02月03日 12:30
 */
@Data
public class Student {

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;


}
