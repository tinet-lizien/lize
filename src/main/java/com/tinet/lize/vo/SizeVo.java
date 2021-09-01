package com.tinet.lize.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author lize
 * @date 2021年09月01日 14:35
 */
@Data
public class SizeVo {

    @NotNull
    @Length(max = 5,message = "最大长度为5")
    private String name;
}
