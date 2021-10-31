package com.konvi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 员工婚姻状况 枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum InfMaritalEnum implements CodeEnum<Integer>
{
    UNMARRIED(0,"未婚"),
    MARRIED(1,"已婚"),
    DIVORCED(2,"离异"),
    WIDOWED(3,"丧偶");

    private Integer code;
    private String message;
}
