package com.konvi.DAO;

import com.konvi.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentsDAO extends JpaRepository<Departments, String>
{
    /**
     *根据id查询
     */
    List<Departments> queryByDepId(String depId);
}
