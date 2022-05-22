package com.tinet.lize01.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author lize
 * @date 2021年08月31日 10:47
 */
@Data
public class LimitOffset {

    @NotNull
    @Range(min = 0,message = "非法请求参数！")
    private Integer limit;

    @NotNull
    @Range(min = 10,max = 100,message = "非法请求参数！")
    private Integer offset;
}
