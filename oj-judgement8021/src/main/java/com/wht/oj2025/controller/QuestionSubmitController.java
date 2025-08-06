package com.wht.oj2025.controller;


import com.wht.oj2025.annotation.CheckParams;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.dto.QuestionSubmitDTO;
import com.wht.oj2025.feignApi.QuestionFeignApi;
import com.wht.oj2025.result.PageResult;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.service.QuestionSubmitService;
import com.wht.oj2025.vo.QuestionSubmitVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/judge")
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @CheckParams(required = "language,code,questionId")
    @PostMapping("/submit")
    public Result<Long> submit(@RequestBody QuestionSubmitDTO questionSubmitDTO) {
        log.info("提交答案 questionSubmitDTO:{}", questionSubmitDTO);
        Long res = questionSubmitService.submit(questionSubmitDTO);
        return Result.success(res);
    }

    @PostMapping("/getList")
    public Result<PageResult> getPage(@RequestBody QuestionSubmitDTO questionSubmitDTO){
        log.info("查询提交 questionSubmitDTO:{}", questionSubmitDTO);
        PageResult res = questionSubmitService.getPage(questionSubmitDTO);
        return Result.success(res);
    }

    @GetMapping("/get/{id}")
    public Result<QuestionSubmitVO> getSubmitInfo(@RequestBody QuestionSubmitDTO questionSubmitDTO,
                                                  @PathVariable("id") Long id){
        log.info("查看结果：{}", id);
        QuestionSubmitVO res = questionSubmitService.getSubmitInfo(questionSubmitDTO, id);
        return Result.success(res);
    }

}
