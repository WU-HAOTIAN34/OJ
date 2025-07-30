package com.wht.oj2025.result;


import com.wht.oj2025.enumeration.ResponseCode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Time;

@Data
@Accessors(chain = true)
public class Result <T> {

    private Integer code;
    private Long timestamp;
    private String message;
    private T data;

    public static <T> Result<T> success(Integer code, String msg, T data) {
        Result res = new Result<>()
                .setCode(code)
                .setMessage(msg)
                .setData(data)
                .setTimestamp(System.currentTimeMillis());
        return res;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result res = new Result<>()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMessage(msg)
                .setData(data)
                .setTimestamp(System.currentTimeMillis());
        return res;
    }

    public static <T> Result<T> success(T data) {
        Result res = new Result<>()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMessage(ResponseCode.SUCCESS.getMessage())
                .setData(data)
                .setTimestamp(System.currentTimeMillis());
        return res;
    }


    public static <T> Result<T> success() {
        Result<T> res = new Result<>();
        res.setCode(ResponseCode.SUCCESS.getCode());
        res.setTimestamp(System.currentTimeMillis());
        res.setMessage(ResponseCode.SUCCESS.getMessage());
        return res;
    }

    public static <T> Result<T> error(ResponseCode rc, String msg) {
        Result res = new Result<>()
                .setCode(rc.getCode())
                .setData(rc.getMessage())
                .setMessage(msg)
                .setTimestamp(System.currentTimeMillis());
        return res;
    }


}
