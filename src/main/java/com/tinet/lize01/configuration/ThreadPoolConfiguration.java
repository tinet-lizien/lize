package com.tinet.lize01.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;

/**
 * 线程池配置
 *
 * @author lizy
 * @date 2019/08/13
 */
@Configuration
@Slf4j
public class ThreadPoolConfiguration {

    @Value("${thread-pool.psd.core-size:5}")
    private Integer psdCoreSize;
    @Value("${thread-pool.psd.max-size:10}")
    private Integer psdMaxSize;

    /**
     * 任务执行器 号码状态检测任务
     */
    @Bean
    public ThreadPoolTaskExecutor phoneStatusDetectionTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(psdCoreSize);
        executor.setMaxPoolSize(psdMaxSize);
        executor.setQueueCapacity(0);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("phone-status-detection-thread-pool-%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动 phone_status_detection 线程池");

        return executor;
    }

    @Bean
    public ThreadPoolTaskExecutor agendaRemindTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(0);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("agenda-remind-thread-pool-%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动agendaRemindThreadPool线程池");

        return executor;
    }

    /**
     * 这为什么都用这么多的线程啊，建议不应该是，1-2倍的cpu数吗
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor ticketEventExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(0);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ticket-event-thread-pool-%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动ticket-event线程池");

        return executor;
    }

    /**
     * 外呼任务导入线程池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor taskPropertyImportExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("task-import-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("task-import-%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动taskPropertyImportThreadPool");

        return executor;
    }

    /**
     * 客户资料导入-解析至redis队列线程池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor customerImportToRedisExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("customer-import-redis");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("customer-import-redis%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动customerImportToRedisThreadPool");

        return executor;
    }

    /**
     * 客户资料导入线程池-redis队列取数据存入数据库
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor customerImportToDbExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("customer-import-db");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("customer-import-db%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动customerImportToDbThreadPool");

        return executor;
    }

    /**
     * 客户资料导入-解析至redis队列线程池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor autoTaskPropertyImportToRedisExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("autoTaskProperty-import-redis");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("autoTaskProperty-import-redis%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动autoTaskPropertyImportToRedisThreadPool");

        return executor;
    }

    /**
     * 客户资料导入线程池-redis队列取数据存入数据库
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor autoTaskPropertyImportToDbExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("autoTaskProperty-import-db");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("autoTaskProperty-import-db%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("启动autoTaskPropertyImportToDbThreadPool");

        return executor;
    }


    /**
     * 自动外呼任务 任务调度线程池
     */
    @Bean
    public ThreadPoolTaskExecutor autoTaskWorkerExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(10000);
        executor.setThreadNamePrefix("autoTask-worker");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("autoTask-worker-%d")
                .setUncaughtExceptionHandler((thread, exception) ->
                        log.error(thread.toString(), exception)
                ).build();

        executor.setThreadFactory(threadFactory);

        executor.initialize();

        log.info("正在启动autoTaskWorkerExecutor...");

        return executor;
    }
}
