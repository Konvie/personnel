package com.lll.controller;


import com.lll.entity.Salaries;
import com.lll.exception.SalariesException;
import com.lll.form.SalariesForm;
import com.lll.service.ISalariesService;
import com.lll.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

/**
 * 工资表 Controller层
 * http://127.0.0.1:8080/personnel/salaries/list
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */
@Slf4j
@Controller
@RequestMapping("/salaries")
public class SalariesController
{
    @Autowired
    private ISalariesService salariesService;

    /**
     * 分页查询工资表
     * @param page 默认为第一页
     * @param size 默认显示10条数据
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue ="1") Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size, Map<String,Object> map)
    {
        PageRequest pageRequest = PageRequest.of(page - 1,size);

        Page<Salaries> salariesPageList = salariesService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("salariesPageList",salariesPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("salaries/list",map);
    }

    /**
     * 弹出 工资表修改页面
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "empId",required = false)String empId,Map<String,Object>map)
    {
        if (empId != null)
        {
            Salaries salaries = salariesService.findById(empId);
            map.put("salaries",salaries);
        }
        return new ModelAndView("salaries/index",map);
    }

    /**
     * 保存/更新 工资表信息
     * @param salariesForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid SalariesForm salariesForm,BindingResult bindingResult,Map<String,Object>map)
    {
        if (bindingResult.hasErrors())
        {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/personnel/salaries/index");
            return new ModelAndView("common/error",map);
        }
        Salaries salaries = new Salaries();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            if (salariesForm.getEmpId() != null)
            {
                salaries = salariesService.findById(salariesForm.getEmpId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                salariesForm.setEmpId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(salariesForm,salaries);

            // 工资信息入库
            salariesService.save(salaries);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/salaries/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/personnel/salaries/list");
        return new ModelAndView("common/success",map);
    }
}
