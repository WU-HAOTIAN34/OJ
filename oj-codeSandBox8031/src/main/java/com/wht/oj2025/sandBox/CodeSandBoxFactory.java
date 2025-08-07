package com.wht.oj2025.sandBox;


import com.wht.oj2025.enumeration.LanguageEnum;
import com.wht.oj2025.sandBox.impl.JavaDockerCodeSandBox;
import com.wht.oj2025.sandBox.impl.JavaNativeCodeSandBox;
import org.springframework.beans.factory.annotation.Value;

public class CodeSandBoxFactory {

    @Value("${sand-box-method:native}")
    private static String sandBoxMethod;

    public static CodeSandBox forInstance(String language) {
        String value = LanguageEnum.JAVA.getValue();
        if (sandBoxMethod.equals("native")) {
            switch (LanguageEnum.forValue(language)) {
                case JAVA:
                    return new JavaNativeCodeSandBox();
                case CPP:
                    return null;
                case GO:
                    return null;
                default:
                    return new JavaNativeCodeSandBox();
            }
        }else{
            switch (LanguageEnum.forValue(language)) {
                case JAVA:
                    return new JavaDockerCodeSandBox();
                case CPP:
                    return null;
                case GO:
                    return null;
                default:
                    return new JavaDockerCodeSandBox();
            }
        }
    }

}
