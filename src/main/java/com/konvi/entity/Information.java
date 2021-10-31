package com.konvi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konvi.enums.InfMaritalEnum;
import com.konvi.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 背景表 JavaBean
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@Entity
@Data
@DynamicUpdate
public class Information implements Serializable
{
    @Id
    /**
     * 信息ID
     */
    private String infId;

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
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp  //这样入职时间就不会为空了
    private Date infEntry;

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
    public InfMaritalEnum getInfMaritalEnum()
    {
        return EnumUtil.getByCode(infMarital,InfMaritalEnum.class);
    }
}
