package com.konvi.controller;


import com.konvi.entity.Salaries;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.PersonnelException;
import com.konvi.exception.SalariesException;
import com.konvi.form.SalariesForm;
import com.konvi.service.ISalariesService;
import com.konvi.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;


/**
 * 工资表 Controller层
 * http://192.168.1.3/:8080/personnel/salaries/list
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
     * @param request
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid SalariesForm salariesForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        // bindingResult.hasErrors()是为了验证@Valid后面的bean 里是否有不符合注解条件的错误信息
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/salaries/index");
            return new ModelAndView("common/error");
        }
        Salaries salaries = new Salaries();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            // StringUtils.hasText(String) 若String值为null或''等,则返回值为false
            if (StringUtils.hasText(salariesForm.getEmpId()))
            {
                salaries = salariesService.findById(salariesForm.getEmpId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                salariesForm.setEmpId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(salariesForm,salaries);

            // 最终金额
            BigDecimal salFinal;

            // 计算最终金额
            salFinal = salaries.getSalBase().add(salaries.getSalBonus()).add(salaries.getSalBenefits()).subtract(salaries.getSalFine());

            // 将最终金额传入数据库中
            salaries.setSalFinal(salFinal);

            // 工资信息入库
            salariesService.save(salaries);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url","/personnel/salaries/index");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.EMPLOYEE_SALARIES_SUCCESS.getMessage());
        session.setAttribute("url","/personnel/salaries/list");
        return new ModelAndView("common/success");
    }

    /**
     * 删除 工资表信息
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("empId")String empId,Map<String,Object>map)
    {
        try
        {
            salariesService.delete(empId);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/salaries/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.EMPLOYEE_SALARIES_SUCCESS.getMessage());
        map.put("url","/personnel/salaries/list");
        return new ModelAndView("common/success",map);
    }
}
