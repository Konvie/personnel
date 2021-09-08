package com.konvi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登出页面
 */
@Controller
@RequestMapping("/common")
public class ManagerLogOut
{
    @RequestMapping("/logout")
    public ModelAndView logout()
    {
        return new ModelAndView("common/logout");
    }

}
