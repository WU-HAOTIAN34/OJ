package com.wht.oj2025.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.wht.oj2025.result.JudgeResult;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class QuestionSubmitVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long questionId;

    private String language;

    private String status;

    private String code;

    private JudgeResult judgeResult;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;



}
