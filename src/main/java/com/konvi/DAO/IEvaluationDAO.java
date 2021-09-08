package com.konvi.DAO;

import com.konvi.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEvaluationDAO extends JpaRepository<Evaluation, String>
{
    /**
     *根据id查询
     */
    List<Evaluation> queryByEmpId(String empId);
}
