package com.konvi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konvi.enums.InfMaritalEnum;
import com.konvi.enums.EmpSexEnum;
import com.konvi.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工表对应的 JavaBean
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="employees")
public class Employees implements Serializable
{
    private static final long serialVersionUID=1L;

    /**
     * 员工id号
     */
    @Id
    //用自定义主键策略 生成自定义主键ID
    //参考：https://www.cnblogs.com/DevMuYuer/p/10088425.html
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "emp-id")
    //@GenericGenerator(name = "emp-id", strategy = "com.konvi.utils.EmpIDGenerator")
    private String empId;

    /**
     * 员工照片
     */
    //这里需要标明这个字段，否则JPA 会自动添加数据库字段，出现问题
    @Column(name="emp_id_photo")
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
     * varchar 32
     */
    //private String depId;

    /**
     * 员工部门名称
     */
    private String depName;

    /**
     * 员工身份证号码
     */
    //这里需要标明这个字段，否则JPA 会自动添加数据库字段，出现问题
    @Column(name = "emp_id_card")
    private String empIdCard;

    /**
     * 备注
     */
    private String empRemarks;

    /**
     * 获取性别  枚举常量类
     */
    @JsonIgnore
    public EmpSexEnum getEmpSexEnum()
    {
        return EnumUtil.getByCode(empSex,EmpSexEnum.class);
    }


}
