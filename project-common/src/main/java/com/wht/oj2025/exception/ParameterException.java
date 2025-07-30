package com.wht.oj2025.exception;

import com.wht.oj2025.enumeration.ResponseCode;

public class ParameterException extends BaseException {
    public ParameterException(ResponseCode responseCode) {
        super(responseCode);
    }
    public ParameterException(String msg) {
        super(msg);
    }
}
