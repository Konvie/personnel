package com.konvi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 日志切面 -- 前置通知
 */
@Aspect
@Component
@Slf4j
public class BeforeLogAspect
{
    /**
     * 前置通知
     * 1. 在执行目标方法之前执行，比如请求接口之前的登录验证;
     * 2. 在前置通知中设置请求日志信息，如开始时间，请求参数，注解内容等
     */
    //@Before("within(com.lll.aop.HelloController)")
    @Before("execution(* com.konvi.service.impl.*ServiceImpl.*(..))")
    public void doBefore(JoinPoint joinPoint)
    {
        Signature signature = joinPoint.getSignature();     // method的一个封装,不提供invoke方法

        String methodName = signature.getName();             // 方法名

        Class declaringType = signature.getDeclaringType();  // 表示该方法的所属的类

        String declaringTypeName = signature.getDeclaringTypeName(); // 表示该方法的所属的类的类名(String类型)

        // int modifiers = signature.getModifiers();            // 表示该方法的修饰符

        Object[] args = joinPoint.getArgs();                 // 获取方法参数

        // Object target = joinPoint.getThis();                 // 获取目标类的实例(老程序员喜欢这样写)  方法1
        // Object target = joinpoint.getTarget();            // 获取目标类的实例(建议新手这样写)      方法2


        // 这里只关心交叉业务逻辑
        log.info(
                methodName
                        + " execute at "
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " args:" + Arrays.toString(args)
        );
    }
}
