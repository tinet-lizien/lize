package com.tinet.lize.controller;

import com.tinet.lize.data.ResponseModel;
import com.tinet.lize.vo.LimitOffset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseModel get(@RequestParam(required = false) String name, @Valid LimitOffset limitOffset){
        log.info("name:{},limit:{},offset:{}",name,limitOffset.getLimit(),limitOffset.getOffset());
        return new ResponseModel(HttpStatus.OK,"get");
    }

    @PostMapping("/post")
    public ResponseModel save(@RequestBody LimitOffset limitOffset){
        log.info("limit:{},offset:{}",limitOffset.getLimit(),limitOffset.getOffset());
        return new ResponseModel(HttpStatus.OK,"post");
    }

    @PutMapping("/put/{id}")
    public ResponseModel update(@RequestBody LimitOffset limitOffset,@PathVariable Integer id){

        log.info("limit:{},offset:{},id:{}",limitOffset.getLimit(),limitOffset.getOffset(),id);
        return new ResponseModel(HttpStatus.OK,"put");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseModel delete(@PathVariable Integer id){

        log.info("id:{}",id);
        return new ResponseModel(HttpStatus.OK,"delete");
    }


}
