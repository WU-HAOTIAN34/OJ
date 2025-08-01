package com.wht.oj2025.service.impl;

import com.wht.oj2025.feignApi.UserFeignApi;
import com.wht.oj2025.mapper.QuestionMapper;
import com.wht.oj2025.service.QuestionService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserFeignApi userFeignApi;


    @Override
    public UserVO test(HttpServletRequest request) {
        return userFeignApi.getLoginUser().getData();
    }
}
