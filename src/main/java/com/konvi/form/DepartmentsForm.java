package com.konvi.form;

import lombok.Data;


/**
 * 封装员工信息修改 新增 传递的数据
 */
@Data
public class DepartmentsForm
{
    /** 部门id */
    private String depId;

    /** 部门名称 */
    private String depName;

    /** 部门描述 */
    private String depDescribes;

    /** 备注 */
    private String depRemarks;
}
