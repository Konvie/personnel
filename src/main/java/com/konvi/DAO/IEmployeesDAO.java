package com.konvi.DAO;

import com.konvi.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 员工 DAO
 */
public interface IEmployeesDAO extends JpaRepository<Employees,String>
{
    /**
     * 根据员工姓名 查询相关员工 (考虑重名情况)
     * @return
     */
    List<Employees> queryByEmpName(String empName);


    /**
     * 根据员工姓名 查询相关员工 (不考虑重名)
     * @param empName
     * @return
     */
    Employees findByEmpName(String empName);

}
