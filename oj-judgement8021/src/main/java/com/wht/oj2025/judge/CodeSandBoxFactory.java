package com.wht.oj2025.judge;


import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.judge.impl.RemoteSandBox;
import com.wht.oj2025.judge.impl.ThirdPartSandBox;
import com.wht.oj2025.result.CodeSandBoxResult;
import org.springframework.beans.factory.annotation.Value;

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
