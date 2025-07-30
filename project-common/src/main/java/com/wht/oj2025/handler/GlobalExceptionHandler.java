package com.wht.oj2025.handler;


import com.wht.oj2025.enumeration.ResponseCode;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.exception.ParameterException;
import com.wht.oj2025.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public Result<String> baseExceptionHandler(RuntimeException e) {
        log.error(e.getMessage());
        return Result.error(ResponseCode.INTERNAL_SERVER_ERROR, "");
    }

    @ExceptionHandler({BaseException.class, ParameterException.class})
    public Result<String> commonExceptionHandler(BaseException e) {
        log.error("{}: {}", e.getCode(), e.getMessage());
        return Result.error(ResponseCode.getByCode(e.getCode()), e.getMessage());
    }


}
