package com.easy.springboot.pojo.query;

import lombok.Data;

@Data
public class StudentQuery {
    private Integer page;
    private Integer limit;

    private String name;
    private Integer banjiId;
}
