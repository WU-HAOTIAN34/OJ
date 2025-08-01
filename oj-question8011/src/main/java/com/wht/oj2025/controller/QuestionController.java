package com.wht.oj2025.controller;


import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.QuestionService;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @GetMapping("")
    public Result<String> test(@Value("${info}") String s, HttpServletRequest request) {
        return Result.success(s);
    }

}
