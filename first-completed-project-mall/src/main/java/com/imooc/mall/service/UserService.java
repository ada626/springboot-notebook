package com.imooc.mall.service;

import com.imooc.mall.exception.MallException;
import com.imooc.mall.model.pojo.User;

public interface UserService {
    User getUser();

    void register(String username, String passWord) throws MallException;

    void adminRegister(String username, String password, Integer role) throws MallException;

    User login(String username, String password) throws MallException;

    void updateUserInfo(User user) throws MallException;

    boolean checkAdminRole(User user);
}

