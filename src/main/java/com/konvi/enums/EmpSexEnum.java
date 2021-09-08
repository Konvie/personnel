package com.konvi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 员工性别的构造类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EmpSexEnum implements CodeEnum<Integer>
{
    WOMAN(0,"女"),
    MAN(1,"男");
    private Integer code;
    private String message;


}
