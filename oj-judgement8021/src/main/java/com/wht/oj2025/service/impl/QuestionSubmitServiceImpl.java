package com.wht.oj2025.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONUtil;
import com.wht.oj2025.constant.CommonConstant;
import com.wht.oj2025.constant.QuestionSubmitConstant;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.QuestionConfig;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.dto.QuestionSubmitDTO;
import com.wht.oj2025.entity.QuestionSubmit;
import com.wht.oj2025.enumeration.LanguageEnum;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.feignApi.QuestionFeignApi;
import com.wht.oj2025.feignApi.UserFeignApi;
import com.wht.oj2025.mapper.QuestionSubmitMapper;
import com.wht.oj2025.result.JudgeResult;
import com.wht.oj2025.result.PageResult;
import com.wht.oj2025.service.QuestionSubmitService;
import com.wht.oj2025.vo.QuestionSubmitVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionSubmitServiceImpl implements QuestionSubmitService {

    @Resource
    private QuestionSubmitMapper questionSubmitMapper;

    @Resource
    private UserFeignApi userFeignApi;

    @Resource
    private QuestionFeignApi questionFeignApi;

    public Long submit(QuestionSubmitDTO questionSubmitDTO) {
        UserVO user = userFeignApi.getLoginUser().getData();
        if (user == null) {
            throw new BaseException(UserConstant.USER_NOT_LOGIN);
        }
        if (!LanguageEnum.getLanguageList().contains(questionSubmitDTO.getLanguage())) {
            throw new BaseException(QuestionSubmitConstant.LANGUAGE_ERROR);
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitDTO, questionSubmit);
        questionSubmit.setUserId(user.getId());
        questionSubmit.setCreateTime(DateTime.now());
        questionSubmit.setUpdateTime(DateTime.now());
        questionSubmit.setIsDelete(CommonConstant.STATE_NORMAL);
        questionSubmit.setStatus(QuestionStatus.WAITING.getCode());
        questionSubmit.setJudgeInfo("{}");
        int insert = questionSubmitMapper.insert(questionSubmit);
        if (insert != 1) {
            throw new BaseException(CommonConstant.DATABASE_ERROR);
        }
        questionFeignApi.updateQuestion(new QuestionDTO().setSubmitNum(1), questionSubmit.getQuestionId());
        Long id = questionSubmit.getId();

        return id;
    }

    public PageResult getPage(QuestionSubmitDTO questionSubmitDTO){
        if (questionSubmitDTO.getStartPage() <= 0){
            throw new BaseException(ResponseCode.PARAMS_ERROR);
        }
        questionSubmitDTO.setStartPage((questionSubmitDTO.getStartPage()-1)*questionSubmitDTO.getPageSize());
        List<QuestionSubmit> list = questionSubmitMapper.queryList(questionSubmitDTO);
        List<QuestionSubmitVO> arrayList = new ArrayList<>();
        for (QuestionSubmit questionSubmit : list){
            QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
            BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
            questionSubmitVO.setCode(null)
                    .setStatus(QuestionStatus.getByCode(questionSubmit.getStatus()).getStatus())
                    .setJudgeResult(JSONUtil.toBean(questionSubmit.getJudgeInfo(), JudgeResult.class));
            arrayList.add(questionSubmitVO);
        }
        PageResult pageResult = new PageResult().setPageList(arrayList).setTotal(list.size());
        return pageResult;
    }

    public QuestionSubmitVO getSubmitInfo(QuestionSubmitDTO questionSubmitDTO, Long id){
        QuestionSubmit questionSubmit = questionSubmitMapper.selectByPrimaryKey(id);
        QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
        questionSubmitVO.setStatus(QuestionStatus.getByCode(questionSubmit.getStatus()).getStatus())
                .setJudgeResult(JSONUtil.toBean(questionSubmit.getJudgeInfo(), JudgeResult.class));
        UserVO user = userFeignApi.getLoginUser().getData();
        if (user == null) {
            throw new BaseException(UserConstant.USER_NOT_LOGIN);
        }
        if (user.getId().intValue() != questionSubmit.getUserId().intValue()) {
            questionSubmitVO.setCode(null);
        }
        return questionSubmitVO;
    }





    public QuestionSubmit doJudge(Long id){
        return null;
    }


}
