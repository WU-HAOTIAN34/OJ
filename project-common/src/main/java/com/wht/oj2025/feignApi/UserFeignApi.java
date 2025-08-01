package com.wht.oj2025.feignApi;



import com.wht.oj2025.dto.UserDTO;
import com.wht.oj2025.result.Result;
import com.wht.oj2025.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("oj-user-service")
public interface UserFeignApi {

    @PostMapping("/user/login")
    Result<UserVO> login(@RequestBody UserDTO userDTO);

    @PostMapping("/user/register")
    Result<Long> register(@RequestBody UserDTO userDTO);

    @GetMapping("/user/getLogin")
    Result<UserVO> getLoginUser();
}
