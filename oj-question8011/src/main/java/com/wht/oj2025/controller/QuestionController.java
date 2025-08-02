package com.wht.oj2025.controller;


import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.QuestionService;
import com.wht.oj2025.vo.QuestionVO;
import com.wht.oj2025.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @CheckParams(required = "title,content,tags,answer,judgeCase,judgeConfig")
    @PostMapping("/create")
    public Result<Long> createQuestion(@RequestBody QuestionDTO questionDTO) {
        log.info("创建题目");
        Question res = questionService.createQuestion(questionDTO);
        return Result.success(res.getId());
    }




    @GetMapping("")
    public Result<UserVO> test( HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE));
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        UserVO test = questionService.test();
        return Result.success(test);
    }

}
