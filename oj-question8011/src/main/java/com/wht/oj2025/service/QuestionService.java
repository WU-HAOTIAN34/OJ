package com.wht.oj2025.service;

import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface QuestionService {

    UserVO test(HttpServletRequest request);
}
