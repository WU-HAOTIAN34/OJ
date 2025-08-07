package com.wht.oj2025.result;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JudgeResult {

    private Long memory;

    private Long time;

    private String msg;

}
