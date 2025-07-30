package com.wht.oj2025.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.UserLoginDTO;
import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.exception.ParameterException;
import com.wht.oj2025.mapper.UserMapper;
import com.wht.oj2025.service.UserService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        if (!userRegisterDTO.getUserPassword().equals(userRegisterDTO.getCheckPassword())) {
            throw new ParameterException(UserConstant.PASSWORD_NOT_SAME);
        }
        if (userRegisterDTO.getUserAccount().length() < 4) {
            throw new ParameterException(UserConstant.ACCOUNT_LENGTH_ERROR);
        }
        if (userRegisterDTO.getUserPassword().length() < 8) {
            throw new ParameterException(UserConstant.PASSWORD_LENGTH_ERROR);
        }

        synchronized (userRegisterDTO.getUserAccount().intern()) {
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userAccount", userRegisterDTO.getUserAccount());
            List<User> users = userMapper.selectByExample(example);
            if (!users.isEmpty()) {
                throw new BaseException(UserConstant.ACCOUNT_REPEAT_ERROR);
            }
            User user = new User();
            BeanUtil.copyProperties(userRegisterDTO, user);
            user.setUserName("新用户" + System.currentTimeMillis());
            user.setCreateTime(DateTime.now());
            user.setUpdateTime(DateTime.now());
            user.setIsDelete((byte) 0);
            user.setUserRole("user");
            user.setUserPassword(DigestUtils.md5DigestAsHex((UserConstant.PASSWORD_SALT
                    + userRegisterDTO.getUserPassword()).getBytes()));
            int insert = userMapper.insert(user);
            if (insert == 0) {
                throw new BaseException(CommonConstant.DATABASE_ERROR);
            }

            return user;

        }
    }


    public UserVO login(UserLoginDTO userLoginDTO){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("user_account", userLoginDTO.getUserAccount());
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            throw new BaseException(UserConstant.ACCOUNT_NOT_EXIST);
        }
        if (!DigestUtils.md5DigestAsHex((UserConstant.PASSWORD_SALT
                + userLoginDTO.getUserPassword()).getBytes())
                .equals(users.get(0).getUserPassword())) {
            throw new BaseException(UserConstant.PASSWORD_INCORRECT);
        }
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(users.get(0), userVO);
        return userVO;
    }
}
