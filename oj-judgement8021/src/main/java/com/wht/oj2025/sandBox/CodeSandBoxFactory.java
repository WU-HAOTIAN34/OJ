package com.wht.oj2025.sandBox;


import com.wht.oj2025.enumeration.LanguageEnum;
import com.wht.oj2025.sandBox.impl.RemoteSandBox;
import com.wht.oj2025.sandBox.impl.ThirdPartSandBox;

public class CodeSandBoxFactory {

    public static CodeSandBox forInstance(String codeSandBox) {
        switch (codeSandBox){
            case "remote":
                return new RemoteSandBox();
            case "third":
                return new ThirdPartSandBox();
            default:
                return new RemoteSandBox();
        }
    }
}
