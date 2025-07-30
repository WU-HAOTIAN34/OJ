package com.wht.oj2025.controller;



import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.UserLoginDTO;
import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.ParameterException;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.UserService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @CheckParams
    public Result<Long> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("register user : {}", userRegisterDTO);
        User res = userService.register(userRegisterDTO);
        return Result.success(res.getId());
    }

    @PostMapping("/login")
    @CheckParams
    public Result<UserVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("login user : {}", userLoginDTO);
        UserVO res = userService.login(userLoginDTO);
        return Result.success(res);
    }

    @GetMapping("/get/login")
    public Result<UserVO> getLoginUser() {
        return Result.success(null);
    }


    @GetMapping("")
    public Result<String> test(@Value("${info.info}") String st) {
        ResponseCode success = ResponseCode.SUCCESS;
        return Result.success(st);

    }



}
