package com.wht.oj2025.service;

import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.result.PageResult;
import com.wht.oj2025.vo.QuestionVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface QuestionService {

    Question createQuestion(QuestionDTO questionDTO);
    Boolean deleteQuestion(Long id);
    Boolean updateQuestion(QuestionDTO questionDTO, Long id);
    QuestionDTO adminGetQuestionInfo(Long id);
    QuestionVO userGetQuestionInfo(Long id);
    PageResult queryQuestion(QuestionDTO questionDTO);
    UserVO test();

}
