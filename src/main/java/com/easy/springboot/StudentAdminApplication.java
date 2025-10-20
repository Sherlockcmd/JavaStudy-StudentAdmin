package com.easy.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.easy.springboot.mapper")
public class StudentAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAdminApplication.class, args);
    }

}
