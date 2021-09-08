package com.konvi.form;
import lombok.Data;

/**
* 封装员工信息修改 新增 传递的数据
*/
@Data
public class EvaluationForm {

    /** 员工id */
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

