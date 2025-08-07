package com.wht.oj2025.languageStrategy.impl;


import cn.hutool.json.JSONUtil;
import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.dto.QuestionCase;
import com.wht.oj2025.dto.StrategyContext;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.languageStrategy.LanguageStrategy;
import com.wht.oj2025.result.JudgeResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class DefaultStrategy implements LanguageStrategy {


    @Override
    public QuestionStatus doJudge(StrategyContext context) {

        QuestionStatus res = QuestionStatus.SUCCEED;
        List<String> outputList = context.getOutputList();
        List<String> targetList = context.getTargetList();

        if (!(outputList.size() == targetList.size())) {
            res = QuestionStatus.FAILED;
        }

        for (int i = 0; i < outputList.size(); i++) {
            if (!outputList.get(i).equals(targetList.get(i))) {
                res = QuestionStatus.FAILED;
                break;
            }
        }

        if (context.getJudgeResult().getMemory() > context.getMemory() ||
        context.getJudgeResult().getTime() > context.getTime()) {
            res = QuestionStatus.FAILED;
        }

        return res;
    }
}
