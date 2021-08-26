package com.tinet.lize.controller;

import com.tinet.lize.entity.TicketSearchModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lize
 * @date 2021年07月23日 11:33
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test1122";
    }

    @PostMapping("/test2")
    public String test2(@Valid @RequestBody TicketSearchModel ticketSearchModel){

        System.out.println(ticketSearchModel.getStartTime());
        return "test2";
    }
}
