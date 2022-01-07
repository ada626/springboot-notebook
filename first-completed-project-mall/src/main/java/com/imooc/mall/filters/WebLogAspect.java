package com.imooc.mall.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {
    private final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.imooc.mall.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL: " + request.getRequestURL().toString());
        log.info("HTTTP_METHOD:" + request.getMethod());
        log.info("IP:"+request.getRemoteAddr());
//        类信息和签名信息
        log.info("CLASS_METHOD: "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
//        参数
        log.info("ARGS: "+ Arrays.toString(joinPoint.getArgs()));

    }
//注意这里的传参要和returning相对应
    @AfterReturning( pointcut = "webLog()", returning="res")
    public void doAfterReturning(Object res) throws JsonProcessingException {
//        ObjectMapper 是 FastJson把对象转为json格式的工具
        log.info("RESPONSE: "+new ObjectMapper().writeValueAsString(res));
    }

}
