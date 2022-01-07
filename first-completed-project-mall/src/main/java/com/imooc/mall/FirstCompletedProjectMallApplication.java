package com.imooc.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mall.model.dao")
public class FirstCompletedProjectMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstCompletedProjectMallApplication.class, args);
    }

}
