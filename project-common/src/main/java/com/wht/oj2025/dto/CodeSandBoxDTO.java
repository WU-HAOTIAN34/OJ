package com.wht.oj2025.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeSandBoxDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String language;

    private Long time;

    private String code;

    private List<String> cases;

}
