package com.wht.oj2025.result;


import lombok.Data;

import java.sql.Time;

@Data
public class Result <T> {

    private Integer code;
    private Long timestamp;
    private String message;
    private T data;

    public static <T> Result<T> success(Integer code, T data) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setData(data);
        res.setTimestamp(System.currentTimeMillis());
        res.setMessage("success");
        return res;
    }

    public static <T> Result<T> success(String code) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setTimestamp(System.currentTimeMillis());
        return res;
    }

    public static <T> Result<T> error(String code) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setTimestamp(System.currentTimeMillis());
        return res;
    }


}
