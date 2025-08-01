package com.wht.oj2025.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.wht.oj2025.dto.QuestionConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class QuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private List<String> tags;

    private Integer submitNum;

    private Integer acceptedNum;

    private Integer thumbNum;

    private Integer favourNum;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String content;

    private QuestionConfig judgeConfig;

    private UserVO userVO;
}
