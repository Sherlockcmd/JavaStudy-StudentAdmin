package com.easy.springboot.pojo.vo;


import lombok.Data;

@Data
public class StudentVO {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer banjiId;

    private String banjiName;
}
