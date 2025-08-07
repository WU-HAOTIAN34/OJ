package com.wht.oj2025.feignApi;


import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.result.CodeSandBoxResult;
import com.wht.oj2025.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("oj-codeSandBox-service")
public interface CodeSandBoxFeignApi {

    @PostMapping("/sandBox/execute")
    Result<CodeSandBoxResult> execute(@RequestBody CodeSandBoxDTO codeSandBoxDTO);
}
