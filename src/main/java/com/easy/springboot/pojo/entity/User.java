package com.easy.springboot.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
      private Integer id;
      private String name;
      @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
      private String password;
      private String email;
      private String phone;
      private String avatar;


}
