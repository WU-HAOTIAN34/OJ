package com.wht.oj2025.controller;



import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.ParameterException;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result<Long> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("register user : {}", userRegisterDTO);
        if (userRegisterDTO == null) {
            throw new ParameterException(ResponseCode.PARAMS_ERROR);
        }
        if (userRegisterDTO.getUserAccount() == null ||
                userRegisterDTO.getUserPassword() == null ||
                userRegisterDTO.getCheckPassword() == null) {
            throw new ParameterException(CommonConstant.PARAM_VOID);
        }
        User res = userService.register(userRegisterDTO);
        return Result.success(res.getId());
    }


    @GetMapping("")
    public Result<User> test() {
        ResponseCode success = ResponseCode.SUCCESS;
        return Result.success();

    }



}
