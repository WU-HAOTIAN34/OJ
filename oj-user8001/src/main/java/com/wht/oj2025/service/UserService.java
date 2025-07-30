package com.wht.oj2025.service;


import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.entity.User;

public interface UserService {
    User register(UserRegisterDTO userRegisterDTO);
}
