package com.wht.oj2025.feignApi;


import com.wht.oj2025.dto.UserLoginDTO;
import com.wht.oj2025.dto.UserRegisterDTO;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient("oj-user-service")
//public interface UserFeignApi {
//
//    @PostMapping("/user/login")
//    Result<UserVO> login(@RequestBody UserLoginDTO userLoginDTO);
//
//    @PostMapping("/user/register")
//    Result<Long> register(@RequestBody UserRegisterDTO userRegisterDTO);
//}
