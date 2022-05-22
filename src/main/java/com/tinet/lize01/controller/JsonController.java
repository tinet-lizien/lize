package com.tinet.lize01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.lize01.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author lize
 * @date 2021年08月31日 13:52
 */
@RestController
@Slf4j
public class JsonController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/getStudent")
    @ResponseBody
    public Student getStudent() throws IOException {
        Student student = new Student();
        student.setAge(29);
        //验证Student中注解@JsonInclude(JsonInclude.Include.NON_NULL)
        String studentStr = objectMapper.writeValueAsString(student);
        log.info("studentStr:{}",studentStr);

        //验证Student中注解@JsonIgnoreProperties(ignoreUnknown = true)
        studentStr = "{\"age\":29,\"aa\":29}";
        Student ss = objectMapper.readValue(studentStr, Student.class);

        log.info("getName:{}",ss.getName());
        log.info("getAge:{}",ss.getAge());

        return student;
    }
}
