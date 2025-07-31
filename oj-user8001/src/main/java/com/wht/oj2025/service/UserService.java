package com.wht.oj2025.service;


import com.wht.oj2025.dto.UserLoginDTO;
import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    User register(UserRegisterDTO userRegisterDTO);
    UserVO login(UserLoginDTO userLoginDTO, HttpServletRequest request);
    UserVO getLoginUser(HttpServletRequest request);
}
