package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping({"/test"})
    @ResponseBody
    public User personalPage(){
        return userService.getUser();
    }

    public ApiRestResponse register(@RequestParam("userName") String userName,@RequestParam("password") String password) throws MallException {
        if(StringUtils.isEmpty(userName)){
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if(StringUtils.isEmpty(password)){
            return ApiRestResponse.error(MallExceptionEnum.NEED_PASSWORD);
        }
        //密码长度不少于8位
        if(password.length()<8){
            return ApiRestResponse.error(MallExceptionEnum.PASSWORD_NOT_QUALIFIED);
        }
        userService.register(userName,password);
        return ApiRestResponse.success();
    }
}
