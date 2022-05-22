package com.tinet.lize01.plugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.lize01.vo.QuartzLogModel;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.plugins.history.LoggingJobHistoryPlugin;

import java.util.Date;

/**
 * quartz 定时任务插件
 *
 * @author lizy
 * @date 2018/08/24
 */
@Slf4j
public class QuartzJobPlugin extends LoggingJobHistoryPlugin {


    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 定时任务成功或者失败
     *
     * @param context
     * @param jobException
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context,
                               JobExecutionException jobException) {

        Trigger trigger = context.getTrigger();

        if (!getLog().isWarnEnabled()) {
            return;
        }

        //如果打印日志
        String errMsg = jobException == null ? null : jobException.getMessage();
        QuartzLogModel quartzLogModel = new QuartzLogModel();
        quartzLogModel.setStartTime(trigger.getPreviousFireTime());
        quartzLogModel.setEndTime(new Date());
        quartzLogModel.setErrorMessage(errMsg);
        quartzLogModel.setJobDescription(context.getJobDetail().getDescription());
        quartzLogModel.setJobName(context.getJobDetail().getKey().getName());
        quartzLogModel.setJobGroupName(context.getJobDetail().getKey().getGroup());
        quartzLogModel.setTriggerGroupName(trigger.getKey().getGroup());
        quartzLogModel.setTriggerName(trigger.getKey().getName());

        try {
            log.info("_定时任务日志_:{}", objectMapper.writeValueAsString(quartzLogModel));
        } catch (JsonProcessingException e) {
            log.error("定时任务model转为json字符串异常", e);
        }
        if (jobException != null) {
            getLog().error("", jobException);
        }
    }


}
