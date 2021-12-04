package com.tinet.lize.mapper;


import com.tinet.lize.base.BaseMapper;
import com.tinet.lize.entity.Staff;

public interface StaffMapper extends BaseMapper<Staff,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Staff record);

    Integer insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Staff record);

    Integer updateByPrimaryKey(Staff record);
}