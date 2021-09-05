package com.lll.service.Impl;

import com.lll.DAO.ISalariesDAO;
import com.lll.dto.SalariesDTO;
import com.lll.entity.Salaries;
import com.lll.service.ISalariesService;
import com.lll.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 工资表 Service层实现类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@Service
@Transactional
public class SalariesServiceImpl implements ISalariesService
{
    @Autowired
    private ISalariesDAO salariesDAO;

    /**
     * 根据员工编号查询员工工资信息
     * @param empId
     * @return
     */
    @Override
    public Salaries findById(String empId)
    {
        return salariesDAO.findById(empId).orElse(null);
    }

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    @Override
    public Page<Salaries> findAll(Pageable pageable)
    {
        return salariesDAO.findAll(pageable);
    }

    /**
     * 新增员工工资信息
     * @param salaries
     * @return
     */
    @Override
    public Salaries save(Salaries salaries)
    {
        return salariesDAO.save(salaries);
    }

    /**
     * 根据员工编号删除员工工资信息
     * @param empId
     */
    @Override
    public void deleteById(String empId)
    {
        salariesDAO.deleteById(empId);
    }

}
