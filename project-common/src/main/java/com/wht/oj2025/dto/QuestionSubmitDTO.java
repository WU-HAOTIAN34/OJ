package com.wht.oj2025.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSubmitDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer startPage;

    private Integer pageSize;

    private Long questionId;

    private String code;

    private String language;

}
