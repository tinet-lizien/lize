package com.tinet.lize01.entity;

import lombok.Data;

@Data
public class Staff {
    private Integer id;

    private String name;

    private Integer age;

    private Integer deptId;

    private Dept dept;

}