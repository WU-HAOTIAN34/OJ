package com.wht.oj2025.feignApi;


import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("oj-question-service")
public interface QuestionFeignApi {

    @PostMapping("/question/update/{id}")
    Result<Boolean> updateQuestion(@RequestBody QuestionDTO questionDTO,
                                          @PathVariable("id") Long id);


}
