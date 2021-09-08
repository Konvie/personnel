package com.konvi.exception;

import com.konvi.enums.ResultEnum;
import lombok.Getter;

/**
 * 自定义异常类
 */
@Getter
public class PersonnelException extends RuntimeException
{
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 返回异常消息
     */
    public PersonnelException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }

    public PersonnelException(Integer code, String message)
    {
        super(message);
        this.code=code;
    }

}
