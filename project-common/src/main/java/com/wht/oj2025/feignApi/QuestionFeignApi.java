package com.wht.oj2025.feignApi;


import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("oj-question-service")
public interface QuestionFeignApi {



}
