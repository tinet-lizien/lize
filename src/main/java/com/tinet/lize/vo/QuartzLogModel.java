package com.tinet.lize.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author lizy
 * @date 2018/08/24
 */
@Data
public class QuartzLogModel {

    /**
     * 定时任务的jobName
     */
    private String jobName;

    /**
     * 定时任务描述
     */
    private String jobDescription;
    /**
     * 定时任务的jobGroup
     */
    private String jobGroupName;

    /**
     * 定时任务的jobGroup
     */
    private String triggerName;

    /**
     * 触发器组名
     */
    private String triggerGroupName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 错误信息
     */
    private String errorMessage;
}
