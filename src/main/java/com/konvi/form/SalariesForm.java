package com.konvi.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 封装 工资表信息
 * @author konvi
 * @version 1.0
 * @date 2021/9/4
 */
@Data
public class SalariesForm
{

    /**
     * 员工编号 必填
     */
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
     * 备注
     */
    private String salRemarks;
}
