package com.wht.oj2025.mapper;

import com.github.pagehelper.Page;
import com.wht.oj2025.dto.QuestionDTO;
import com.wht.oj2025.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface QuestionMapper extends Mapper<Question> {
    List<Question> queryList(@Param("questionDTO") QuestionDTO questionDTO);
}