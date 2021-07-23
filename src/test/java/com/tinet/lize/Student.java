package com.tinet.lize;

import lombok.Data;

/**
 * @author lize
 * @date 2021年06月20日 16:25
 */
@Data
public class Student {
    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private Integer age;
    private String name;
}
