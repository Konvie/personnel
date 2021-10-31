package com.konvi.service;

import com.konvi.dto.InformationDTO;
import com.konvi.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 工资表 Service层
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
public interface IInfoService
{
    /**
     * 根据员工编号查询员工背景信息
     * @param empId
     * @return
     */
    Information findById(String empId);

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    Page<Information> findAll(Pageable pageable);

    /**
     * 新增员工工资信息
     * @param information
     * @return
     */
    Information save(Information information);

    /**
     * 根据员工编号删除员工工资信息
     * @param empId
     * @return
     */
    void delete(String empId);

    // 根据员工姓名查找员工工资信息
    InformationDTO findByEmpName(String empName);
}
