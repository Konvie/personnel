package com.konvi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "evaluation")
public class Evaluation implements Serializable
{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /** 员工id */
    @Id
    private String empId;

    /** 出勤 */
    private Integer evaAttendance;

    /** 迟到 */
    private Integer evaLate;

    /** 评级 */
    private String evaLevel;

    /** 加班工时 */
    private Integer evaOvertime;

    /** 备注 */
    private String evaRemarks;
}
