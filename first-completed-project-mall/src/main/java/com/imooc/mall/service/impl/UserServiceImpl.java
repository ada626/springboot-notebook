package com.imooc.mall.service.impl;
import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    查询数据库，返回信息
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(){
        //通过主键查询对象
        return userMapper.selectByPrimaryKey(4);
    }
}
