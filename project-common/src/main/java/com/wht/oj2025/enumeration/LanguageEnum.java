package com.wht.oj2025.enumeration;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum LanguageEnum {

    JAVA("java"),
    CPP("cpp"),
    GO("go");

    private final String value;

    LanguageEnum(String value) {
        this.value = value;
    }

    public static List<String> getLanguageList(){
        return Arrays.stream(LanguageEnum.values())
                .map(LanguageEnum::getValue)
                .collect(Collectors.toList());
    }

    public static LanguageEnum forValue(String value) {
        for (LanguageEnum e : LanguageEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }


}
