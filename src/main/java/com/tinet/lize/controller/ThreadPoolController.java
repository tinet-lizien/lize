package com.tinet.lize.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lize
 * @date 2021年08月31日 15:14
 */
@RestController
@Slf4j
public class ThreadPoolController {

    @Value("${thread-pool.psd.core-size:5}")//冒号后面是默认值
    private Integer psdCoreSize;
    @Value("${thread-pool.psd.max-size:10}")//冒号后面是默认值
    private Integer psdMaxSize;

    @Autowired
    @Qualifier("customerImportToDbExecutor")
    private ThreadPoolTaskExecutor customerImportToDbExecutor;

    @GetMapping("/getPoolConfig")
    public void getPoolConfig(){
        log.info("psdCoreSize:{},psdMaxSize:{}",psdCoreSize,psdMaxSize);
    }

    @GetMapping("/threadTest")
    public void threadTest(){
        customerImportToDbExecutor.execute(()->{
            log.info("===========1s==============");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("===========5s==============");
        });
    }
}
