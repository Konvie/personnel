package com.konvi.controller;

import com.konvi.WebSecurityConfig;
import com.konvi.entity.User;
import com.konvi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录
 * http://192.168.1.3:8080/personnel/login
 * 登录用户：root 123456
 */
@Controller
public class UserController
{
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model)
    {
        return "common/index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "common/login";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String username, String password, HttpSession session)
    {
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);

        //System.out.println("test");

        boolean verify= userService.verifyUser(user);
        //boolean verify=true;

        if (verify)
        {
            session.setAttribute(WebSecurityConfig.SESSION_KEY,username);
            return "common/index";
        }
        else
        {
            return "redirect:common/login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:common/login";
    }

}
