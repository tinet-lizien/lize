package com.tinet.lize;

import com.tinet.lize.entity.Dept;
import com.tinet.lize.mapper.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lize
 * @date 2021年12月04日 13:17
 */
//加上这两个注解，运行测试方法的时候就会启动SpringBoot
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Njia1 {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void test1(){
        Dept dept = new Dept();
        dept.setId(4);
        dept.setName("lize");
        dept.setLocation("安徽省临泉县");
        deptMapper.insert(dept);
    }
}
