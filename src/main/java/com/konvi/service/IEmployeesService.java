package com.konvi.service;

import com.konvi.dto.EmployeesDTO;
import com.konvi.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 员工 Service
 */
public interface IEmployeesService
{
    /**
     * 根据员工ID 查询员工信息
     */
    Employees findByEmpId(String empId);
    //EmployeesDTO findByEmpId(String empId);

    /**
     * 根据姓名查询员工信息
     */
    List<Employees> findUpAll(String empName);

    /**
     * 分页查询所有员工信息
     */
    Page<Employees> findAll(Pageable pageable);

    /**
     * 新增员工
     */
    Employees save(Employees employees);
    //EmployeesDTO save(Employees employees);
    /**
     * 修改员工信息
     */
    Employees update(Employees employees);
    //EmployeesDTO update(Employees employees);
    /**
     * 删除员工信息
     */
    void delete(String empId);
    //EmployeesDTO delete(String empId);

    /**
     * 根据员工姓名查找员工
     * @param empName
     * @return
     */
    EmployeesDTO findByEmpName(String empName);

    // List<EmployeesDTO> findByEmpName(String empName);

}
