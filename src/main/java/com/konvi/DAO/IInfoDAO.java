package com.konvi.DAO;

import com.konvi.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 员工表 DAO层
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
public interface IInfoDAO extends JpaRepository<Information,String>
{
    // 根据员工姓名 查找背景信息
    Information findByEmpName(String empName);
}
