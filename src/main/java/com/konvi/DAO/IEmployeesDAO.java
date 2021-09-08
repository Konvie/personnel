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
     * 根据员工姓名 查询相关员工
     * @return
     */
    List<Employees> queryByEmpName(String empName);

}
