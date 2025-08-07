package com.wht.oj2025.judge;


import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.result.CodeSandBoxResult;

public interface CodeSandBox {

    CodeSandBoxResult execute(CodeSandBoxDTO codeSandBoxDTO);
}
