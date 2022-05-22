package com.tinet.lize01.mapper;


import com.tinet.lize01.base.BaseMapper;
import com.tinet.lize01.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Dept record);

    Integer insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Dept record);

    Integer updateByPrimaryKey(Dept record);
}