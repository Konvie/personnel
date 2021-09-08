package com.konvi.service.Impl;

import com.konvi.DAO.IEmployeesDAO;
import com.konvi.entity.Employees;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.PersonnelException;
import com.konvi.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements IEmployeesService
{
    @Autowired
    private IEmployeesDAO employeesDAO;


    /**
     * 根据员工ID 查询员工信息
     *
     * @param empId
     */
    @Override
    public Employees findByEmpId(String empId) {
        return employeesDAO.findById(empId).orElse(null);
    }

    /**
     * 查询所有员工信息  不分页
     */
    @Override
    public List<Employees> findUpAll(String empName) {
        return employeesDAO.queryByEmpName(empName);
    }

    /**
     * 分页查询所有员工信息
     *
     * @param pageable
     */
    @Override
    public Page<Employees> findAll(Pageable pageable)
    {
        return employeesDAO.findAll(pageable);
    }

    /**
     * 新增员工
     *
     * @param employees
     */
    @Override
    public Employees save(Employees employees) {
        return employeesDAO.save(employees);
    }

    /**
     * 修改员工信息
     *
     * @param employees
     */
    @Override
    public Employees update(Employees employees)
    {
        //根据员工ID 查询员工信息
        Employees employee=employeesDAO.findById(employees.getEmpId()).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (employee==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        //TODO 修改员工信息
        return employeesDAO.save(employee);
    }

    /**
     * 删除员工信息
     *
     * @param empId
     */
    @Override
    public void delete(String empId)
    {
        //根据员工ID 查询员工信息
        Employees employee=employeesDAO.findById(empId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (employee==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);

        }
        else
        {
           employeesDAO.delete(employee);
        }


    }
}
