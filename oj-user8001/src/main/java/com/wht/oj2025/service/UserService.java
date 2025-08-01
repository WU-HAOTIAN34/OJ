package com.wht.oj2025.service;


import com.wht.oj2025.dto.UserDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    User register(UserDTO userDTO);
    UserVO login(UserDTO userDTO, HttpServletRequest request);
    UserVO getLoginUser(HttpServletRequest request);
}
