package com.easy.springboot.pojo.query;

import lombok.Data;

@Data
public class BanjiQuery {
    private Integer page;
    private Integer limit;

    private String name;
    private String address;
}
