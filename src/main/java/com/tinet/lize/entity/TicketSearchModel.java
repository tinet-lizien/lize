package com.tinet.lize.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tinet.lize.constant.RegExpConst;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author lize
 * @date 2021年08月23日 19:37
 */
@Data
public class TicketSearchModel {


    /**
     * 开始时间
     */
    @NotNull(message = "工单查询开始时间不能为空")
    @Pattern(regexp = RegExpConst.yyyy_MM_dd_HH_mm_ss ,message = "请填写正确的开始时间！")
    private String startTime;


    /**
     * 结束时间
     */
    @Pattern(regexp = RegExpConst.yyyy_MM_dd ,message = "请填写正确的最近催单开始时间！")
    private String endTime;

}
