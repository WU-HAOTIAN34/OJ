package com.wht.oj2025.vo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPassword;
    private String username;
    private String userAvatar;
    private String userProfile;


}
