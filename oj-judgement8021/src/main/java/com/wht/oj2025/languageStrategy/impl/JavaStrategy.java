package com.wht.oj2025.languageStrategy.impl;


import com.wht.oj2025.dto.StrategyContext;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.languageStrategy.LanguageStrategy;
import com.wht.oj2025.result.JudgeResult;

import java.util.List;

public class JavaStrategy implements LanguageStrategy {

    private final Long JAVA_SET = 1L;

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
                context.getJudgeResult().getTime() > context.getTime()+JAVA_SET) {
            res = QuestionStatus.FAILED;
        }

        return res;
    }
}
