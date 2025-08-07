package com.wht.oj2025.mapper;

import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.dto.QuestionSubmitDTO;
import com.wht.oj2025.entity.Question;
import com.wht.oj2025.entity.QuestionSubmit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface QuestionSubmitMapper extends Mapper<QuestionSubmit> {
    List<QuestionSubmit> queryList(@Param("q") QuestionSubmitDTO questionSubmitDTO);

    @Select("select count(*) from question_submit")
    Integer countNum();
}