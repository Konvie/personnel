package com.konvi.service.Impl;


import com.konvi.DAO.IEvaluationDAO;
import com.konvi.entity.Evaluation;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.PersonnelException;
import com.konvi.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements IEvaluationService
{
    @Autowired
    private IEvaluationDAO evaluationDAO;

    /**  根据ID查询 */
    @Override
    public Evaluation findById(String empId) {
        return evaluationDAO.findById(empId).orElse(null);
    }

    /**  查询所有 */
    @Override
    public List<Evaluation> findAll() {
        return evaluationDAO.findAll();
    }

    /**
     * 分页查询所有员工信息
     *
     */
    @Override
    public Page<Evaluation> findAll(Pageable pageable)
    {
        return evaluationDAO.findAll(pageable);
    }


    /**  新增 */
    @Override
    public Evaluation save(Evaluation evaluation)

    {
        return evaluationDAO.save(evaluation);
    }

    /**  修改 */
    public Evaluation update(Evaluation evaluation)
    {
        //根据员工ID 查询员工信息
        Evaluation evaluation1=evaluationDAO.findById(evaluation.getEmpId()).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (evaluation1==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        //TODO 修改员工信息
        return evaluationDAO.save(evaluation1);
    }

    /**  删除 */
    @Override
    public void delete(String empId)
    {
        //根据员工ID 查询员工信息
        Evaluation evaluation=evaluationDAO.findById(empId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (evaluation==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);

        }
        else
        {
            evaluationDAO.delete(evaluation);
        }


    }
}

