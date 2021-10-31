package com.konvi.controller;


import com.konvi.dto.InformationDTO;
import com.konvi.entity.Information;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.SalariesException;
import com.konvi.form.InformationForm;
import com.konvi.service.IInfoService;
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
import java.util.Map;


/**
 * 背景表 Controller层
 * http://192.168.1.3/:8080/personnel/info/list
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */
@Slf4j
@Controller
@RequestMapping("/info")
public class InfoController
{
    @Autowired
    private IInfoService infoService;

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

        Page<Information> infoPageList = infoService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("infoPageList",infoPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("info/list",map);
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
            Information information = infoService.findById(empId);
            map.put("information", information);
        }
        return new ModelAndView("info/index",map);
    }


    /**
     * 保存/更新 工资表信息
     * @param informationForm
     * @param bindingResult
     * @param request
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid InformationForm informationForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        // bindingResult.hasErrors()是为了验证@Valid后面的bean 里是否有不符合注解条件的错误信息
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/info/index");
            return new ModelAndView("common/error");
        }
        Information information = new Information();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            // StringUtils.hasText(String) 若String值为null或''等,则返回值为false
            if (StringUtils.hasText(informationForm.getEmpId()))
            {
                information = infoService.findById(informationForm.getEmpId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                informationForm.setEmpId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(informationForm, information);

            /*// 最终金额
            BigDecimal salFinal;

            // 计算最终金额
            salFinal = information.getSalBase().add(information.getSalBonus()).add(information.getSalBenefits()).subtract(information.getSalFine());

            // 将最终金额传入数据库中
            information.setSalFinal(salFinal);*/

            // 背景信息入库
            infoService.save(information);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url","/personnel/info/index");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        session.setAttribute("url","/personnel/info/list");
        return new ModelAndView("common/success");
    }

    /**
     * 删除 背景表信息
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("empId")String empId,Map<String,Object>map)
    {
        try
        {
            infoService.delete(empId);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/info/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        map.put("url","/personnel/info/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "empName", required = false) String empName, Map<String, Object> map)
    {
        return new ModelAndView("info/search", map);
    }


    @GetMapping("/result")
    public ModelAndView result(@RequestParam("empName") String empName, Map<String, Object> map, HttpServletRequest request)
    {
        String contextPath = "";
        InformationDTO informationDTO = new InformationDTO();
        try {
            informationDTO = infoService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("salaries", informationDTO);
        return new ModelAndView("info/result", map);
    }
}
