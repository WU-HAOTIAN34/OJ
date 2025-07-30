package com.wht.oj2025.controller;


import cn.hutool.core.date.DateTime;
import com.wht.oj2025.dto.UserLoginDTO;
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
    public Result<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            throw new ParameterException(ResponseCode.PARAMS_ERROR);
        }

        User user = new User().builder()
                .useraccount(map.get("useraccount"))
                .userpassword(map.get("useraccount"))
                .username("新用户" + System.currentTimeMillis())
                .createtime(DateTime.now())
                .updatetime(DateTime.now())
                .userrole("user")
                .isdelete((byte)0).build();

        return Result.success("200", user);
    }

    @GetMapping("")
    public Result<User> test() {
        ResponseCode success = ResponseCode.SUCCESS;
        return Result.success("200");

    }



}
