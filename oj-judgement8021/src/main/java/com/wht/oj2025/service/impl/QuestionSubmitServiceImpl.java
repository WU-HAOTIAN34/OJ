package com.wht.oj2025.service.impl;

import com.wht.oj2025.feignApi.UserFeignApi;
import com.wht.oj2025.mapper.QuestionSubmitMapper;
import com.wht.oj2025.service.QuestionSubmitService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class QuestionSubmitServiceImpl implements QuestionSubmitService {

    @Resource
    private QuestionSubmitMapper questionSubmitMapper;

    @Resource
    private UserFeignApi userFeignApi;


}
