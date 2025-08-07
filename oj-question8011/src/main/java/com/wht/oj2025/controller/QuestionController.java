package com.wht.oj2025.controller;


import com.wht.oj2025.annotation.CheckAuth;
import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.constant.UserConstant;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.entity.User;
import com.wht.oj2025.result.PageResult;
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

import java.util.List;

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

    @PostMapping("/delete/{id}")
    public Result<Boolean> deleteQuestion(@PathVariable("id") Long id){
        log.info("删除题目：{}", id);
        Boolean res = questionService.deleteQuestion(id);
        return Result.success(res);
    }


    @CheckAuth(reqAuth = UserConstant.USER_ADMIN)
    @PostMapping("/update/{id}")
    public Result<Boolean> updateQuestion(@RequestBody QuestionDTO questionDTO,
                                          @PathVariable("id") Long id,
                                          HttpServletRequest request){
        log.info("更新题目：{}", id);
        Boolean res = questionService.updateQuestion(questionDTO, id);
        return Result.success(res);
    }


    @CheckAuth(reqAuth = UserConstant.USER_ADMIN)
    @GetMapping("/admin/get/{id}")
    public Result<QuestionDTO> adminGetQuestionInfo(@PathVariable("id") Long id, HttpServletRequest request) {
        log.info("查看题目信息：{}", id);
        QuestionDTO res = questionService.adminGetQuestionInfo(id);
        return Result.success(res);
    }

    @GetMapping("/user/get/{id}")
    public Result<QuestionVO> userGetQuestionInfo(@PathVariable("id") Long id, HttpServletRequest request) {
        log.info("查看题目信息：{}", id);
        QuestionVO res = questionService.userGetQuestionInfo(id);
        return Result.success(res);
    }

    @PostMapping("/getList")
    public Result<PageResult> getQuestionList(@RequestBody QuestionDTO questionDTO,
                                              HttpServletRequest request) {
        log.info("查询题目：{}", questionDTO);
        PageResult pageResult = questionService.queryQuestion(questionDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/inside/get/{id}")
    public Result<QuestionDTO> getQuestionInfo(@PathVariable("id") Long id) {
        log.info("查看题目信息：{}", id);
        QuestionDTO res = questionService.adminGetQuestionInfo(id);
        return Result.success(res);
    }




    @GetMapping("")
    public Result<UserVO> test( HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE));
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        UserVO test = questionService.test();
        return Result.success(test);
    }


    @GetMapping("/test")
    @CheckAuth(reqAuth = "user")
    public Result<UserVO> test1( HttpServletRequest request) {

        return Result.success();
    }

}
