package com.wht.oj2025.controller;


import com.wht.oj2025.service.QuestionSubmitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/judge")
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;


}
