package com.lll.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置静态资源映射
 * @author Konvi
 * @version 1.0
 * @date 2021/9/4
 */

@Configuration
public class WebAppConfig implements WebMvcConfigurer
{
    @Override
    // addResourceHandler是指你想在url请求的路径
    // addResourceLocations是真实路径
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/**/*").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
}
