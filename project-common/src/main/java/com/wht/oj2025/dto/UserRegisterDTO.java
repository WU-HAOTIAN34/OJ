package com.wht.oj2025.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
