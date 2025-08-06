package com.wht.oj2025.result;


import com.wht.oj2025.dto.QuestionConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeResult {

    private Integer status;

    private List<String> res;

    private String msg;

    private QuestionConfig questionConfig;

}
