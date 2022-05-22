package com.tinet.lize01.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * 运营分析-定时任务
 *
 * @author Chenjf
 * @date 2019/11/27 20:08
 **/
@Slf4j
public class AnalysisTask implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        long start = System.currentTimeMillis();
        log.info("定时任务 运营分析 开始执行 start {}", start);

        LocalDateTime crateTime = LocalDateTime.now();
        //定时任务收集前一天的数据
        long lastDayTime = crateTime.plusDays(-1).withHour(23).withMinute(59).withSecond(59)
                .toEpochSecond(OffsetDateTime.now().getOffset());

        //收集业务统计数据
        log.info("定时任务 运营分析 业务统计 开始执行 start {}", System.currentTimeMillis());
        try {
            System.out.println("定时任务开始。。。");
        } catch (Exception e) {
            log.error("定时任务执行[业务统计]时发生异常", e);
        }
        log.info("定时任务 运营分析 业务统计 执行完成 end {}", System.currentTimeMillis());

        long end = System.currentTimeMillis();
        log.info("定时任务 运营分析 执行完成 start {} end {} duration {}", start, end, end - start);
    }

}
