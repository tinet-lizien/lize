package com.tinet.lize.mapper;


import com.tinet.lize.base.BaseMapper;
import com.tinet.lize.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper extends BaseMapper<Staff,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Staff record);

    Integer insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Staff record);

    Integer updateByPrimaryKey(Staff record);

    List<Staff> list();
}