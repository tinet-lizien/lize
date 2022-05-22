package com.tinet.lize01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lize
 * @date 2021年07月22日 16:41
 */
@EnableAutoConfiguration
@ComponentScan("com.tinet.lize01")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
