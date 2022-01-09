package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping({"/test"})
    @ResponseBody
    public User personalPage(){
        return userService.getUser();
    }

    @PostMapping({"/register"})
    @ResponseBody
    public ApiRestResponse register(@RequestParam("username") String username, @RequestParam("password") String password) throws MallException {
        if(StringUtils.isEmpty(username)){
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if(StringUtils.isEmpty(password)){
            return ApiRestResponse.error(MallExceptionEnum.NEED_PASSWORD);
        }
        //密码长度不少于8位
        if(password.length()< 8){
            return ApiRestResponse.error(MallExceptionEnum.PASSWORD_NOT_QUALIFIED);
        }
        userService.register(username,password);
        return ApiRestResponse.success();
    }
    @PostMapping({"/login"})
    @ResponseBody
    public ApiRestResponse login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws MallException {
        if (StringUtils.isEmpty(username)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(username,password);
        user.setPassword(null);
        session.setAttribute(Constant.MALL_USER,user);
        return ApiRestResponse.success(user);
    }

    @PostMapping({"/user/update"})
    @ResponseBody
    public ApiRestResponse updateUserInfo(HttpSession session,@RequestParam("signature") String signature) throws MallException {
        User currentUser = (User) session.getAttribute(Constant.MALL_USER);
        if(currentUser==null){
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateUserInfo(user);
        return ApiRestResponse.success();
    }
    @PostMapping("/user/logout")
    @ResponseBody
    public ApiRestResponse logout(HttpSession session){
        session.removeAttribute(Constant.MALL_USER);
        return ApiRestResponse.success();
    }
    @PostMapping({"/adminlogin"})
    @ResponseBody
    public ApiRestResponse adminlogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws MallException {
        if (StringUtils.isEmpty(username)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(username,password);
        //check if user is admin
        if (userService.checkAdminRole(user)) {
            user.setPassword(null);
            session.setAttribute(Constant.MALL_USER,user);
            return ApiRestResponse.success(user);
        }
       return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN);

    }
}
