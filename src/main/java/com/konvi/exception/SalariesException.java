package com.konvi.exception;

import com.konvi.enums.ResultEnum;

/**
 * 自定义异常类
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */

public class SalariesException extends RuntimeException
{
    private Integer code;

    /**
     * 只输入异常信息
     * @param resultEnum
     */
    public SalariesException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    /**
     * 输入异常编号和异常信息
     * @param code
     * @param message
     */
    public SalariesException(Integer code,String message)
    {
        super(message);
        this.code = code;
    }
}
