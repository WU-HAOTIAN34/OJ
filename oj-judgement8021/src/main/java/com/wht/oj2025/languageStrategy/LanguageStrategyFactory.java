package com.wht.oj2025.languageStrategy;


import com.wht.oj2025.dto.StrategyContext;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.languageStrategy.impl.DefaultStrategy;
import com.wht.oj2025.languageStrategy.impl.JavaStrategy;

public class LanguageStrategyFactory {

    public static LanguageStrategy forInstance (String language) {
        switch (language){
            case "Java":
                return new JavaStrategy();
            case "default":
                return new DefaultStrategy();
            default:
                return new DefaultStrategy();
        }
    }

}
