package com.wht.oj2025.controller;



import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.dto.UserDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.UserService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    @CheckParams(required = "userAccount,userPassword,checkPassword")
    public Result<Long> register(@RequestBody UserDTO userDTO) {
        log.info("register user : {}", userDTO);
        User res = userService.register(userDTO);
        return Result.success(res.getId());
    }

    @PostMapping("/login")
    @CheckParams(required = "userAccount,userPassword")
    public Result<UserVO> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        log.info("login user : {}", userDTO);
        UserVO res = userService.login(userDTO, request);
        return Result.success(res);
    }

    @GetMapping("/getLogin")
    public Result<UserVO> getLoginUser(HttpServletRequest request) {
        log.info("查询登陆状态");
        HttpSession session = request.getSession();
        UserVO res = userService.getLoginUser(request);
        return Result.success(res);
    }

    @PostMapping("/logout")
    public Result<Boolean> userLogout(HttpServletRequest request) {
        log.info("退出登录");
        Boolean res = userService.userLogout(request);
        return Result.success(res);
    }

    @PostMapping("/update")
    public Result<Boolean> updateUserInfo(@RequestBody UserVO userVO, HttpServletRequest request) {
        log.info("update user : {}", userVO.getId());
        Boolean res = userService.updateUserInfo(userVO, request);
        return Result.success(res);
    }
}
