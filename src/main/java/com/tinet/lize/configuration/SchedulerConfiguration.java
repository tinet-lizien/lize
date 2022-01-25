package com.tinet.lize.configuration;

import com.tinet.lize.task.AnalysisTask;
import org.quartz.Trigger;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 定时任务调度器配置
 *
 * @author Jiangsl
 * @date 2018/05/24
 */
@Configuration
public class SchedulerConfiguration {
    private static final String NAMESPACE = "report";

    @Autowired
    @Qualifier("quartzDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("quartzTransactionManager")
    private PlatformTransactionManager transactionManager;


    @Value("${quartz.analysis.cronExpression}")
    private String analysisExpression;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 扩展SpringBeanJobFactory，使Job实现类支持@autowired注入
     */
    private final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

        private transient AutowireCapableBeanFactory beanFactory;

        @Override
        public void setApplicationContext(final ApplicationContext context) {
            beanFactory = context.getAutowireCapableBeanFactory();
        }

        @Override
        protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
            final Object job = super.createJobInstance(bundle);
            beanFactory.autowireBean(job);
            return job;
        }
    }

    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

        quartzScheduler.setDataSource(dataSource);
        quartzScheduler.setTransactionManager(transactionManager);
        quartzScheduler.setOverwriteExistingJobs(true);
        quartzScheduler.setSchedulerName(NAMESPACE);

        // 加载Quartz的配置文件
        quartzScheduler.setConfigLocation(new ClassPathResource("/quartz.properties"));

        // 使Quartz Job支持@Autowired注入
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        quartzScheduler.setJobFactory(jobFactory);

        // 加载任务触发器
        Trigger[] triggers = { analysisTrigger().getObject()};
        quartzScheduler.setTriggers(triggers);

        return quartzScheduler;
    }


    @Bean
    public CronTriggerFactoryBean analysisTrigger() {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(analysisJobDetail().getObject());
        trigger.setCronExpression(analysisExpression);
        trigger.setGroup(NAMESPACE);
        return trigger;
    }

    @Bean
    public JobDetailFactoryBean analysisJobDetail() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setJobClass(AnalysisTask.class);
        jobDetail.setDurability(true);
        jobDetail.setGroup(NAMESPACE);
        jobDetail.setDescription("运营分析");
        return jobDetail;
    }

}
