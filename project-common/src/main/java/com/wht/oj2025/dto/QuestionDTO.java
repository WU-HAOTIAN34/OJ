package com.wht.oj2025.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Accessors(chain = true)
public class QuestionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer startPage;

    private Integer pageSize;

    private Integer submitNum;

    private Integer acceptedNum;

    private String title;

    private List<String> tags;

    private Long userId;

    private String content;

    private String answer;

    private List<QuestionCase> judgeCase;

    private QuestionConfig judgeConfig;
}
