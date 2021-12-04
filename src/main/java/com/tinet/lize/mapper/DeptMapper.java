package com.tinet.lize.mapper;


import com.tinet.lize.base.BaseMapper;
import com.tinet.lize.entity.Dept;
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