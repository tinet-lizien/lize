package com.tinet.lize01;

import com.tinet.lize01.entity.Dept;
import com.tinet.lize01.entity.Staff;
import com.tinet.lize01.mapper.DeptMapper;
import com.tinet.lize01.mapper.StaffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void insert(){
        Dept dept = new Dept();
        dept.setId(2);
        dept.setName("lize2");
        dept.setLocation("安徽省临泉县2");
        deptMapper.insert(dept);
    }

    @Test
    public void selectById(){
        Dept dept = deptMapper.selectByPrimaryKey(1);
        System.out.println(dept);
    }

    @Test
    public void list(){
        List<Staff> staffList = staffMapper.list();
        System.out.println(staffList);
    }
}
