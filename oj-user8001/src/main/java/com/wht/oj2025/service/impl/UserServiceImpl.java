package com.wht.oj2025.service.impl;

import com.wht.oj2025.mapper.UserMapper;
import com.wht.oj2025.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
}
