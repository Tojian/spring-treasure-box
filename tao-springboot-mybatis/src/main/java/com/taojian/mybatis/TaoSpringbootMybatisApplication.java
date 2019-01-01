package com.taojian.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taojian.mybatis.mapper")
public class TaoSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaoSpringbootMybatisApplication.class, args);
    }

}

