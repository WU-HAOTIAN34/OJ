package com.wht.oj2025.aspect;


import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.ParameterException;
import jdk.jshell.MethodSnippet;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
@Slf4j
public class CheckParamsAspect {

    @Pointcut("@annotation(com.wht.oj2025.annotation.CheckParams)")
    public void CheckParamsPointcut() {}


    @Around("CheckParamsPointcut()")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckParams annotation = signature.getMethod().getAnnotation(CheckParams.class);

        String s1 = annotation.required();
        String s2 = annotation.excludeReq();
        Object[] args = joinPoint.getArgs();
        Object entity = args[0];
        if (entity == null) {
            throw new ParameterException(ResponseCode.PARAMS_ERROR);
        }
        Field[] declaredFields = entity.getClass().getDeclaredFields();

        if (s2.isEmpty()){
            boolean flag = s1.equals("ALL");
            Set<String> hashset = new HashSet<>(Arrays.asList(s1.split(",")));
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                String fieldName = field.getName();
                if ((hashset.contains(fieldName) || flag) && value == null) {
                    throw new ParameterException(CommonConstant.PARAM_VOID);
                }
            }
        }else{
            Set<String> hashset = new HashSet<>(Arrays.asList(s2.split(",")));
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                String fieldName = field.getName();
                if (!hashset.contains(fieldName) && value == null) {
                    throw new ParameterException(CommonConstant.PARAM_VOID);
                }
            }
        }
        return joinPoint.proceed();
    }


}
