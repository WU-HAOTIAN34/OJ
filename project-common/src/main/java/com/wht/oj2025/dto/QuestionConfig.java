package com.wht.oj2025.dto;


import lombok.Data;

@Data
public class QuestionConfig {
    private Long timeLimit;
    private Long memoryLimit;
    private Long stackLimit;
}
