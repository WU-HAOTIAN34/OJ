package com.wht.oj2025.exception;


import com.wht.oj2025.enumeration.ResponseCode;

public class BaseException extends RuntimeException {

    private Integer code;

    public BaseException() {
    }

    public BaseException(ResponseCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public BaseException(String message) {
        super(message);
        this.code = ResponseCode.OPERATION_FAIL.getCode();
    }

    public Integer getCode(){
        return code;
    }
}
