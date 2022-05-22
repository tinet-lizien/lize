package com.tinet.lize01;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lize
 * @date 2021年06月20日 16:25
 */
@Data
@NoArgsConstructor
public class StudentCopy {
    public StudentCopy(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private Integer age;
    private String name;
}
