package com.wht.oj2025.handler;


import com.wht.oj2025.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public Result<String> baseExceptionHandler(RuntimeException e) {
        log.info(e.getMessage());
        return
    }


}
