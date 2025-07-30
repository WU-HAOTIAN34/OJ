package com.wht.oj2025.aspect;


import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
@Slf4j
public class CheckParamsAspect {

    @Pointcut("@annotation(com.wht.oj2025.annotation.CheckParams)")
    public void CheckParamsPointcut() {}


    @Around("CheckParamsPointcut()")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Object entity = args[0];

        if (entity == null) {
            throw new ParameterException(ResponseCode.PARAMS_ERROR);
        }
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object value = field.get(entity);
            if (value == null) {
                throw new ParameterException(CommonConstant.PARAM_VOID);
            }
        }
        return joinPoint.proceed();
    }


}
