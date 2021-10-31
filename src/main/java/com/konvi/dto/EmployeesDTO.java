package com.konvi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konvi.entity.Employees;
import com.konvi.enums.InfMaritalEnum;
import com.konvi.enums.EmpSexEnum;
import com.konvi.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 员工DTO 用来传输数据
 */
@Data
@DynamicInsert
@DynamicUpdate
public class EmployeesDTO {
    /**
     * 员工id号
     */
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "emp-id")
    //@GenericGenerator(name = "emp-id", strategy = "com.lll.utils.EmpIDGenerator")
    private String empId;

    /**
     * 员工照片
     */
    private String empPhoto;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工性别
     * 1为男生，0为女生
     */
    //private Integer empSex;
    private Integer empSex= EmpSexEnum.MAN.getCode();   //默认为男生

    /**
     * 员工邮箱
     */
    private String empEmail;

    /**
     * 员工手机号码
     */
    private String empPhone;

    /**
     * 员工部门编号
     */
    private String depId;

    /**
     * 员工部门名称
     */
    private String depName;

    /**
     * 员工身份证号码
     */
    private String empIdCard;

    /**
     * 备注
     */
    private String empRemarks;

    @Transient
    List<Employees> employees;

    /**
     * 获取性别  枚举常量类
     */
    @JsonIgnore
    public EmpSexEnum getEmpSexEnum()
    {
        return EnumUtil.getByCode(empSex,EmpSexEnum.class);
    }


}
