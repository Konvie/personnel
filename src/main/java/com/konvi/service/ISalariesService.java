package com.konvi.service;

import com.konvi.entity.Salaries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 工资表 Service层
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
public interface ISalariesService
{
    /**
     * 根据员工编号查询员工工资信息
     * @param empId
     * @return
     */
    Salaries findById(String empId);

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    Page<Salaries> findAll(Pageable pageable);

    /**
     * 新增员工工资信息
     * @param salaries
     * @return
     */
    Salaries save(Salaries salaries);

    /**
     * 根据员工编号删除员工工资信息
     * @param empId
     * @return
     */
    void delete(String empId);

}
