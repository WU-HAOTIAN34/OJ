package com.wht.oj2025.sandBox.impl;


import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.feignApi.CodeSandBoxFeignApi;
import com.wht.oj2025.sandBox.CodeSandBox;
import com.wht.oj2025.result.CodeSandBoxResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


public class RemoteSandBox implements CodeSandBox {



    @Override
    public CodeSandBoxResult execute(CodeSandBoxDTO codeSandBoxDTO) {
        return null;
    }
}
