package com.konvi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "departments")
public class Departments implements Serializable
{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /** 部门id */
    @Id
    private String depId;

    /** 部门名称 */
    @Column(name = "dep_name")
    private String depName;

    /** 部门描述 */
    private String depDescribes;

    /** 备注 */
    private String depRemarks;

}
