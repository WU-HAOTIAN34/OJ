package com.wht.oj2025.result;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageResult {

    Integer total;
    List pageList;
}
