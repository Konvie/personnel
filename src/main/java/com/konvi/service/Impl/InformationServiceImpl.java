package com.konvi.service.Impl;

import com.konvi.DAO.IInformationDAO;
import com.konvi.dto.InformationDTO;
import com.konvi.entity.Information;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.PersonnelException;
import com.konvi.service.IInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 工资表 Service层实现类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@Service
@Transactional
public class InformationServiceImpl implements IInformationService
{
    @Autowired
    private IInformationDAO informationDAO;


    /**
     * 根据员工编号查询员工工资信息
     * @param empId
     * @return
     */
    @Override
    public Information findById(String empId)
    {
        return informationDAO.findById(empId).orElse(null);
    }

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    @Override
    public Page<Information> findAll(Pageable pageable)
    {
        return informationDAO.findAll(pageable);
    }

    /**
     * 新增员工工资信息
     * @param information
     * @return
     */
    @Override
    public Information save(Information information)
    {
        return informationDAO.save(information);
    }

    /**
     * 根据员工编号删除员工工资信息
     * @param empId
     */
    @Override
    public void delete(String empId)
    {
        //根据员工ID 查询员工信息
        Information information = informationDAO.findById(empId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (information == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_SALARIES_NOT_EXIST);
        }

        else
        {
            informationDAO.delete(information);
        }
    }

    /**
     * 根据员工姓名查找员工工资信息
     * @param empName
     * @return
     */
    @Override
    public InformationDTO findByEmpName(String empName)
    {
        // 根据员工姓名查询 员工信息
        Information information = informationDAO.findByEmpName(empName);
        if (information == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_SALARIES_NOT_EXIST);
        }

        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(information, informationDTO);
        return informationDTO;
    }

}
