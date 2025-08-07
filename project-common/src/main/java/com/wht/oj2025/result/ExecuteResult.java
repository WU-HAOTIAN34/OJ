package com.wht.oj2025.result;


import lombok.Data;

@Data
public class ExecuteResult {

    private Integer exitCode;

    private String msg;

    private String errorMsg;

    private Long time;

    private Long memory;

}
