package com.wht.oj2025.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String unionId;

    private String mpOpenId;

    private String userName;

    private String userAvatar;

    private String userProfile;

    private String userRole;

}
