package com.wht.oj2025.dto;


import com.wht.oj2025.entity.Question;
import com.wht.oj2025.entity.QuestionSubmit;
import com.wht.oj2025.result.JudgeResult;
import feign.form.multipart.Output;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StrategyContext {

    private List<String> targetList;

    private List<String> outputList;

    private Long time;

    private Long memory;

    private JudgeResult judgeResult;


}
