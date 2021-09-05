package com.lll.enums;

import lombok.Getter;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */

@Getter
public enum ResultEnum
{
    Test(200,"这是个测试");

    /**
     * 编号
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 重构枚举类
     * @param code
     * @param message
     */
    ResultEnum(Integer code,String message)
    {
        this.code = code;
        this.message = message;
    }
}
