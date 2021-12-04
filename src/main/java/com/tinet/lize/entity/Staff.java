package com.tinet.lize.entity;

import lombok.Data;

@Data
public class Staff {
    private Integer id;

    private String name;

    private Integer age;

    private Integer deptId;

    private Dept dept;

}