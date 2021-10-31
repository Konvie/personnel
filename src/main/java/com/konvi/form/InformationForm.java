package com.konvi.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konvi.enums.InfMaritalEnum;
import com.konvi.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 封装 背景表信息
 * @author konvi
 * @version 1.0
 * @date 2021/9/4
 */
@Data
public class InformationForm
{
    /**
     * 员工ID
     */
    private String empId;


    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 学历
     */
    private String infEducation;

    /**
     * 政治面貌
     */
    private String infPolitical;

    /**
     * 籍贯
     */
    private String infPlace;

    /**
     * 婚姻状况
     */
    private Integer infMarital= InfMaritalEnum.UNMARRIED.getCode(); //默认未婚

    /**
     * 备注
     */
    private String infRemarks;

    /**
     * 获取婚姻状态的枚举类
     */
    @JsonIgnore
    public InfMaritalEnum getEmpMaritalEnum()
    {
        return EnumUtil.getByCode(infMarital,InfMaritalEnum.class);
    }
}
