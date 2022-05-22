package com.tinet.lize01.controller;

import com.tinet.lize01.vo.SizeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lize
 * @date 2021年09月01日 14:33
 */
@RestController
@Slf4j
public class SizeController {

    @GetMapping("/sizeTest")
    public void sizeTest(@Valid SizeVo sizeVo){

        log.info("name:{}",sizeVo.getName());
    }
}
