package com.tinet.lize01.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author lize
 * @date 2021年09月01日 14:35
 */
@Data
public class SizeVo {

    @NotNull
    @Length(max = 5,message = "最大长度为5")
    private String name;

    @NotNull
    @Pattern(regexp = "^(http|https)://([\\w.]+\\/?)\\S*",message = "url格式错误")
    private String url;
}
