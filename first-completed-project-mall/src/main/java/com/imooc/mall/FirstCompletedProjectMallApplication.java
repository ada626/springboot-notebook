package com.imooc.mall;

import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.util.MD5Utils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mall.model.dao")
public class FirstCompletedProjectMallApplication {


    public static void main(String[] args) {
        SpringApplication.run(FirstCompletedProjectMallApplication.class, args);
    }

}
