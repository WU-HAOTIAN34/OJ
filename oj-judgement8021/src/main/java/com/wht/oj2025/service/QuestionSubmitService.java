package com.wht.oj2025.service;

import com.wht.oj2025.dto.QuestionSubmitDTO;
import com.wht.oj2025.result.PageResult;
import com.wht.oj2025.vo.QuestionSubmitVO;

public interface QuestionSubmitService {

    Long submit(QuestionSubmitDTO questionSubmitDTO);
    PageResult getPage(QuestionSubmitDTO questionSubmitDTO);
    QuestionSubmitVO getSubmitInfo(QuestionSubmitDTO questionSubmitDTO, Long id);

}
