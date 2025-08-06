package com.wht.oj2025.enumeration;


import lombok.Data;
import lombok.Getter;


@Getter
public enum QuestionStatus {

    WAITING("等待中", 0),
    RUNNING("判题中", 1),
    SUCCEED("成功", 2),
    FAILED("失败", 3),
    NULL(null, null);

    private final String status;
    private final Integer code;

    QuestionStatus(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public static QuestionStatus getByCode(Integer code) {
        for (QuestionStatus r : QuestionStatus.values()) {
            if (r.getCode().intValue()==code.intValue()) {
                return r;
            }
        }
        return NULL;
    }
}
