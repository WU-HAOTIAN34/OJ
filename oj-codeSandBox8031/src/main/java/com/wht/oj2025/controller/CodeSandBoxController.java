package com.wht.oj2025.controller;


import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.result.CodeSandBoxResult;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.sandBox.CodeSandBox;
import com.wht.oj2025.sandBox.CodeSandBoxFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/sandBox")
public class CodeSandBoxController {

    @PostMapping("/execute")
    public Result<CodeSandBoxResult> execute(CodeSandBoxDTO codeSandBoxDTO) {
        log.info("代码沙箱开始运行：{}", codeSandBoxDTO);
        CodeSandBox codeSandBox = CodeSandBoxFactory.forInstance(codeSandBoxDTO.getLanguage());
        CodeSandBoxResult res = null;
        if (codeSandBox != null) {
            res = codeSandBox.execute(codeSandBoxDTO);
        }
        return Result.success(res);
    }

}
