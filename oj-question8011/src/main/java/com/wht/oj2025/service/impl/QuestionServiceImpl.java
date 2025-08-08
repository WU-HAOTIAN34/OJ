package com.wht.oj2025.service.impl;

import cn.hutool.core.date.DateTime;

import cn.hutool.json.JSONUtil;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.github.pagehelper.PageHelper;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.QuestionConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.QuestionCase;
import com.wht.oj2025.dto.QuestionConfig;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.feignApi.UserFeignApi;
import com.wht.oj2025.mapper.QuestionMapper;
import com.wht.oj2025.result.PageResult;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.QuestionService;
import com.wht.oj2025.vo.QuestionVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        question.setUserId(id);
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

    public Boolean deleteQuestion(Long id){
        String userRole = userFeignApi.getLoginUser().getData().getUserRole();
        if (!userRole.equals("admin")) {
            throw new BaseException(CommonConstant.AUTHORITY_ERROR);
        }
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null || Objects.equals(question.getIsDelete(), CommonConstant.STATE_DELETED)) {
            throw new BaseException(QuestionConstant.QUESTION_EXIST_ERROR);
        }
        Example example = new Example(Question.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        Question question1 = new Question();
        question1.setIsDelete(CommonConstant.STATE_DELETED);
        questionMapper.updateByExampleSelective(question1, example);
        return true;
    }

    public Boolean updateQuestion(QuestionDTO questionDTO, Long id){
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO,question);
        if (questionDTO.getTags() != null) {
            question.setTags(GSON.toJson(questionDTO.getTags()));
            question.setJudgeCase(GSON.toJson(questionDTO.getJudgeCase()));
            question.setJudgeConfig(GSON.toJson(questionDTO.getJudgeConfig()));
            question.setUpdateTime(DateTime.now());
        }
        if (questionDTO.getTitle() != null && question.getTitle().length() > 80) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (questionDTO.getContent() != null && question.getContent().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (questionDTO.getAnswer() != null && question.getAnswer().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (questionDTO.getJudgeCase() != null && question.getJudgeCase().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        if (questionDTO.getJudgeConfig() != null && question.getJudgeConfig().length() > 8192) {
            throw new BaseException(QuestionConstant.TITLE_LENGTH_ERROR);
        }
        Question question1 = questionMapper.selectByPrimaryKey(id);
        if (question1 == null || question1.getIsDelete().equals(CommonConstant.STATE_DELETED)) {
            throw new BaseException(QuestionConstant.QUESTION_EXIST_ERROR);
        }
        if (question.getSubmitNum() != null){
            question.setSubmitNum(question1.getSubmitNum()+1);
        }
        if (question.getAcceptedNum() != null){
            question.setAcceptedNum(question1.getAcceptedNum()+1);
        }
        Example example = new Example(Question.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        int i = questionMapper.updateByExampleSelective(question, example);
        if (i == 0) {
            throw new BaseException(CommonConstant.DATABASE_ERROR);
        }
        return true;
    }

    public QuestionDTO adminGetQuestionInfo(Long id){
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setTags(JSONUtil.toList(question.getTags(), String.class));
        questionDTO.setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), QuestionConfig.class));
        List<String> list = JSONUtil.toList(question.getJudgeCase(), String.class);
        List<QuestionCase> qc = new ArrayList<>();
        for (String s : list) {
            qc.add(JSONUtil.toBean(s, QuestionCase.class));
        }
        questionDTO.setJudgeCase(qc);
        return questionDTO;
    }

    public QuestionVO userGetQuestionInfo(Long id){
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question ==null || question.getIsDelete().equals(CommonConstant.STATE_DELETED)) {
            throw new BaseException(QuestionConstant.QUESTION_EXIST_ERROR);
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question,questionVO);
        questionVO.setTags(JSONUtil.toList(question.getTags(), String.class));
        questionVO.setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), QuestionConfig.class));
        return questionVO;
    }


    public PageResult queryQuestion(QuestionDTO questionDTO){
        if (questionDTO.getStartPage() <= 0){
            throw new BaseException(ResponseCode.PARAMS_ERROR);
        }
        questionDTO.setStartPage((questionDTO.getStartPage()-1)*questionDTO.getPageSize());
        List<Question> questions = questionMapper.queryList(questionDTO);
        UserVO user = null;
        try {
            Result<UserVO> loginUser = userFeignApi.getLoginUser();
            user = loginUser.getData();
        }catch (Exception e){
            System.out.println("未登录");
        }
        if (user != null && user.getUserRole().equals(UserConstant.USER_ADMIN)){
            List<QuestionVO> res = new ArrayList<>();
            for (Question question : questions) {
                QuestionVO questionVO = new QuestionVO();
                BeanUtils.copyProperties(question,questionVO);
                questionVO.setTags(JSONUtil.toList(question.getTags(), String.class))
                        .setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), QuestionConfig.class));
                res.add(questionVO);
            }
            PageResult pageResult = new PageResult().setPageList(res).setTotal(questions.size());
            return pageResult;
        }else{
            List<QuestionVO> res = new ArrayList<>();
            for (Question question : questions) {
                QuestionVO questionVO = new QuestionVO();
                BeanUtils.copyProperties(question,questionVO);
                questionVO.setTags(JSONUtil.toList(question.getTags(), String.class))
                        .setContent(null);
                res.add(questionVO);
            }
            PageResult pageResult = new PageResult().setPageList(res).setTotal(questionMapper.countNum());
            return pageResult;
        }
    }



    @Override
    public UserVO test() {
        Result<UserVO> loginUser = userFeignApi.getLoginUser();
        UserVO data = loginUser.getData();
        return data;
    }
}
