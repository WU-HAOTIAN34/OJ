package com.wht.oj2025.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.UserDTO;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.exception.ParameterException;
import com.wht.oj2025.mapper.UserMapper;
import com.wht.oj2025.service.UserService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User register(UserDTO userDTO) {
        if (!userDTO.getUserPassword().equals(userDTO.getCheckPassword())) {
            throw new ParameterException(UserConstant.PASSWORD_NOT_SAME);
        }
        if (userDTO.getUserAccount().length() < 4) {
            throw new ParameterException(UserConstant.ACCOUNT_LENGTH_ERROR);
        }
        if (userDTO.getUserPassword().length() < 8) {
            throw new ParameterException(UserConstant.PASSWORD_LENGTH_ERROR);
        }
        synchronized (userDTO.getUserAccount().intern()) {
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userAccount", userDTO.getUserAccount());
            List<User> users = userMapper.selectByExample(example);
            if (!users.isEmpty()) {
                throw new BaseException(UserConstant.ACCOUNT_REPEAT_ERROR);
            }
            User user = new User();
            BeanUtil.copyProperties(userDTO, user);
            user.setUserName("新用户" + System.currentTimeMillis());
            user.setCreateTime(DateTime.now());
            user.setUpdateTime(DateTime.now());
            user.setIsDelete(CommonConstant.STATE_NORMAL);
            user.setUserRole(UserConstant.USER_DEFAULT_ROLE);
            user.setUserPassword(DigestUtils.md5DigestAsHex((UserConstant.PASSWORD_SALT
                    + userDTO.getUserPassword()).getBytes()));
            int insert = userMapper.insert(user);
            if (insert == 0) {
                throw new BaseException(CommonConstant.DATABASE_ERROR);
            }
            return user;
        }
    }


    public UserVO login(UserDTO userDTO, HttpServletRequest request){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userAccount", userDTO.getUserAccount());
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            throw new BaseException(UserConstant.ACCOUNT_NOT_EXIST);
        }
        if (!DigestUtils.md5DigestAsHex((UserConstant.PASSWORD_SALT
                + userDTO.getUserPassword()).getBytes())
                .equals(users.get(0).getUserPassword())) {
            throw new BaseException(UserConstant.PASSWORD_INCORRECT);
        }
        if (users.get(0).getUserRole().equals(UserConstant.USER_BAN)) {
            throw new BaseException(UserConstant.USER_BANNED);
        }
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(users.get(0), userVO);
        request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE, users.get(0));
        return userVO;
    }


    public UserVO getLoginUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        if (user == null) {
            throw new BaseException(UserConstant.USER_NOT_LOGIN);
        }
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if (user1 == null || Objects.equals(user1.getIsDelete(), CommonConstant.STATE_DELETED)) {
            throw new BaseException(UserConstant.USER_DELETED);
        }
        if (user1.getUserRole().equals(UserConstant.USER_BAN)) {
            throw new BaseException(UserConstant.USER_BANNED);
        }
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user1, userVO);
        user.setUserRole(userVO.getUserRole());
        return userVO;
    }

    public Boolean userLogout(HttpServletRequest request){
        if (request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE) == null) {
            throw new BaseException(UserConstant.USER_NOT_LOGIN);
        }
        request.getSession().removeAttribute(UserConstant.USER_LOGIN_STATE);
        return true;
    }

    public Boolean updateUserInfo(UserVO userVO, HttpServletRequest request){
        if (userVO == null) {
            throw new ParameterException(ResponseCode.PARAMS_ERROR);
        }
        if (userVO.getUserName().length() > 16) {
            throw new ParameterException(UserConstant.USERNAME_LENGTH_ERROR);
        }
        if (userVO.getUserProfile().length() > 64) {
            throw new ParameterException(UserConstant.USERPROFILE_LENGTH_ERROR);
        }
        User user = new User();
        user.setUpdateTime(DateTime.now());
        BeanUtil.copyProperties(userVO, user);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", user.getId());
        int i = userMapper.updateByExample(user, example);
        if (i == 0) {
            throw new BaseException(CommonConstant.DATABASE_ERROR);
        }
        request.getSession().removeAttribute(UserConstant.USER_LOGIN_STATE);
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE, user1);
        return true;
    }


}
