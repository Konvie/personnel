package com.konvi.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 工资表 JavaBean
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@Entity
@Data
@DynamicUpdate
public class Salaries implements Serializable
{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @Id
    private String empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 基本金额
     */
    private BigDecimal salBase;

    /**
     * 奖金金额
     */
    private BigDecimal salBonus;

    /**
     * 奖金描述
     */
    private String salBonusDescribes;

    /**
     * 扣除金额
     */
    private BigDecimal salFine;

    /**
     * 扣除描述
     */
    private String salFineDescribes;

    /**
     * 保险福利
     */
    private BigDecimal salBenefits;

    /**
     * 最终金额
     */
    private BigDecimal salFinal;

    /**
     * 备注
     */
    private String salRemarks;

}
