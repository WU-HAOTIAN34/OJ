package com.wht.oj2025.languageStrategy;


import com.wht.oj2025.dto.StrategyContext;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.result.JudgeResult;

public interface LanguageStrategy {

    QuestionStatus doJudge(StrategyContext context);

}
