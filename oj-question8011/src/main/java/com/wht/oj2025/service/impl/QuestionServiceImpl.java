package com.wht.oj2025.service.impl;

import cn.hutool.core.date.DateTime;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.QuestionConstant;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.feignApi.UserFeignApi;
import com.wht.oj2025.mapper.QuestionMapper;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.QuestionService;
import com.wht.oj2025.vo.QuestionVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserFeignApi userFeignApi;

    private final static Gson GSON = new Gson();


    public Question createQuestion(QuestionDTO questionDTO){
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO,question);
        question.setTags(GSON.toJson(questionDTO.getTags()));
        question.setJudgeCase(GSON.toJson(questionDTO.getJudgeCase()));
        question.setJudgeConfig(GSON.toJson(questionDTO.getJudgeConfig()));

        if (question.getTitle().length() > 80) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (question.getContent().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (question.getAnswer().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (question.getJudgeCase().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (question.getJudgeConfig().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        Long id = userFeignApi.getLoginUser().getData().getId();
        question.setId(id);
        question.setSubmitNum(CommonConstant.INITIAL_NUM);
        question.setAcceptedNum(CommonConstant.INITIAL_NUM);
        question.setFavourNum(CommonConstant.INITIAL_NUM);
        question.setThumbNum(CommonConstant.INITIAL_NUM);
        question.setCreateTime(DateTime.now());
        question.setUpdateTime(DateTime.now());
        question.setIsDelete(CommonConstant.STATE_NORMAL);
        int insert = questionMapper.insert(question);
        if (insert == 0) {
            throw new BaseException(CommonConstant.DATABASE_ERROR);
        }
        return question;

    }


    @Override
    public UserVO test() {
        Result<UserVO> loginUser = userFeignApi.getLoginUser();
        UserVO data = loginUser.getData();
        return data;
    }
}
