package com.konvi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录配置
 * 登录页面发起请求-->拦截器拦截匹配的url判断session-->后台验证/设置session-->返回
 * 参考：https://blog.csdn.net/huang906391/article/details/78376766
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter
{
    public final static String SESSION_KEY="username";

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    public void  addInterceptors(InterceptorRegistry registry)
    {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");

        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter
    {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
           //获取用户登录信息
            HttpSession session = request.getSession();

            // 判断是否已有该用户登录的session，通过验证
            if(session.getAttribute(SESSION_KEY) != null){
                return true;
            }

            // 如果不满足登录验证 跳转到登录页，目前缺少登录错误提示
            String url = "/personnel/login";
            response.sendRedirect(url);
            return false;
        }
    }


}
