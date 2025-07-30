package com.wht.oj2025.enumeration;


import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS(200, "success"),
    NOT_FOUND(404, "not found"),
    PARAMS_ERROR(400, "parameters error"),
    INTERNAL_SERVER_ERROR(500, "未知系统错误"),
    OPERATION_FAIL(405, "操作失败"),
    NULL(null, null);

    private final Integer code;
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseCode getByCode(Integer code) {
        for (ResponseCode r : ResponseCode.values()) {
            if (r.getCode().intValue()==code.intValue()) {
                return r;
            }
        }
        return NULL;
    }



}
