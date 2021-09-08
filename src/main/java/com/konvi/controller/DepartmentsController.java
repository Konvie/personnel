package com.konvi.controller;

import com.konvi.entity.Departments;
import com.konvi.enums.ResultEnum;
import com.konvi.exception.PersonnelException;
import com.konvi.form.DepartmentsForm;
import com.konvi.service.IDepartmentsService;
import com.konvi.utils.KeyUtil;
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

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
  @Autowired private IDepartmentsService departmentsService;

  /** 部门列表 */
  @GetMapping("/list")
  public ModelAndView list(
      @RequestParam(value = "page", defaultValue = "1") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size,
      Map<String, Object> map) {
    PageRequest pageRequest = PageRequest.of(page - 1, size);

    // 分页查询商品列表
    Page<Departments> departmentsPageList = departmentsService.findAll(pageRequest);

    // 设置商品分页列表
    map.put("departmentsPageList", departmentsPageList);
    // 设置当前页
    map.put("currentPage", page);
    // 设置每页显示多少条数据
    map.put("pageSize", size);

    return new ModelAndView("departments/list", map);
  }

  /** 弹出修改页面 */
  @GetMapping("/index")
  public ModelAndView index(
      @RequestParam(value = "depId", required = false) String depId, Map<String, Object> map) {
    if (depId != null) {
      Departments departments = departmentsService.findById(depId);
      map.put("departments", departments);
    }
    return new ModelAndView("departments/index", map);
  }

  /** 新增 */
  @PostMapping("/save")
  public ModelAndView save(
      @Valid DepartmentsForm form, BindingResult bindingResult, HttpServletRequest request) {
    HttpSession session = request.getSession();
    if (bindingResult.hasErrors()) {
      session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
      session.setAttribute("url", request.getContextPath() + "/departments/index");
      return new ModelAndView("common/error");
    }

    Departments departments = new Departments();
    try {
      if (StringUtils.hasText(form.getDepId())) {
        departments = departmentsService.findById(form.getDepId());
      } else {
        form.setDepId(KeyUtil.genUniqueKey());
      }
      BeanUtils.copyProperties(form, departments);
      departmentsService.save(departments); // 保存/更新
    } catch (PersonnelException e) {
      session.setAttribute("msg", e.getMessage());
      session.setAttribute("url", request.getContextPath() + "/departments/index");
      return new ModelAndView("common/error");
    }
    session.setAttribute("msg", ResultEnum.EMPLOYEE_DEPARTMENTS_SUCCESS.getMessage());
    session.setAttribute("url", request.getContextPath() + "/departments/list");
    return new ModelAndView("common/success");
  }

  /**
   * 删除
   * @param depId
   * @param map
   * @return
   */
  @GetMapping("/delete")
  public ModelAndView delete(@RequestParam("depId")String depId,Map<String,Object>map)
  {
    try
    {
      departmentsService.delete(depId);
    } catch (PersonnelException e)
    {
      map.put("msg",e.getMessage());
      map.put("url","/personnel/departments/list");
      return new ModelAndView("common/error",map);
    }
    map.put("url","/personnel/departments/list");
    return new ModelAndView("common/success",map);
  }

}

