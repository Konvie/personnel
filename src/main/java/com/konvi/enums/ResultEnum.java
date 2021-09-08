package com.konvi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 对错误结果的枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum
{
    EMPLOYEE_NOT_EXIST(100,"该员工不存在"),
    EMPLOYEE_SALARIES_SUCCESS(114,"员工工资操作成功"),
    EMPLOYEE_SUCCESS(115,"员工操作成功"),
    EMPLOYEE_EVALUATION_SUCCESS(116, "员工评价操作成功"),
    EMPLOYEE_DEPARTMENTS_SUCCESS(117,"员工部门操作成功");

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

}
