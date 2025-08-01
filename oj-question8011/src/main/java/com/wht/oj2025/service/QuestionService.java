package com.wht.oj2025.service;

import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.vo.QuestionVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface QuestionService {

    Question createQuestion(QuestionDTO questionDTO);
    UserVO test();
}
