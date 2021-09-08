package com.konvi.DAO;

import com.konvi.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 工资表 DAO层
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
public interface ISalariesDAO extends JpaRepository<Salaries,String>
{

}
