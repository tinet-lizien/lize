package com.tinet.lize.controller;

import com.tinet.lize.vo.LimitOffset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lize
 * @date 2021年07月23日 11:33
 */
@RestController
@Slf4j
public class CurdController {

    @GetMapping("/get")
    public String get(@RequestParam(required = false) String name, @Valid LimitOffset limitOffset){
        log.info("name:{},limit:{},offset:{}",name,limitOffset.getLimit(),limitOffset.getOffset());
        return "get";
    }

    @PostMapping("/post")
    public String save(@RequestBody LimitOffset limitOffset){

        log.info("limit:{},offset:{}",limitOffset.getLimit(),limitOffset.getOffset());
        return "post";
    }

    @PutMapping("/put/{id}")
    public String update(@RequestBody LimitOffset limitOffset,@PathVariable Integer id){

        log.info("limit:{},offset:{},id:{}",limitOffset.getLimit(),limitOffset.getOffset(),id);
        return "update";
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        log.info("id:{}",id);
        return "delete";
    }


}
