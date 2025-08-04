package com.wht.oj2025.aspect;


import com.wht.oj2025.annotation.CheckAuth;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
@Slf4j
public class CheckAuthAspect {

    @Pointcut("@annotation(com.wht.oj2025.annotation.CheckAuth)")
    public void CheckAuthPointcut() {}

    @Around("CheckAuthPointcut()")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckAuth annotation = signature.getMethod().getAnnotation(CheckAuth.class);

        String auth = annotation.reqAuth();
        Object[] args = joinPoint.getArgs();
        Object arg = args[args.length - 1];

        HttpServletRequest request = (HttpServletRequest) arg;
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        if (user == null) {
            throw new BaseException(UserConstant.USER_NOT_LOGIN);
        }

        String userRole = user.getUserRole();
        if (userRole.equals(UserConstant.USER_BAN)){
            throw new BaseException(UserConstant.USER_BANNED);
        }

        Set<String> set = new HashSet<>(Arrays.asList(auth.split(",")));
        if (!set.contains(userRole)){
            throw new BaseException(UserConstant.AUTHORITY_ERROR);
        }

        return joinPoint.proceed();

    }
}
