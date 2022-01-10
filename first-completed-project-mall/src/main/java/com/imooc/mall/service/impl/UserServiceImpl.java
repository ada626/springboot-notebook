package com.imooc.mall.service.impl;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

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
    @Override
    public void register(String username, String password) throws MallException {
        //查询用户名是否存在，不允许重名
        User result = userMapper.selectByUserName(username);
        if(result!=null){
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        //写到数据库
        User user = new User();
        user.setUsername(username);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int count = userMapper.insertSelective(user);
        if(count==0){
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }
    @Override
    public void adminRegister(String username, String password,Integer role) throws MallException {
        //查询用户名是否存在，不允许重名
        User result = userMapper.selectByUserName(username);
        if(result!=null){
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        //写到数据库
        User user = new User();
        user.setUsername(username);
        user.setRole(role);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int count = userMapper.insertSelective(user);
        if(count==0){
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public User login(String username,String password) throws MallException {
        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userMapper.selectLogin(username,md5Password);
        if(user==null){
            throw new MallException(MallExceptionEnum.WRONG_PASSWORD);
        }
        return user;
    }

    @Override
    public void updateUserInfo(User user) throws MallException {
        int updateCount =  userMapper.updateByPrimaryKeySelective(user);
        if(updateCount>1){
            throw new MallException(MallExceptionEnum.UPDATE_FIAILED);
        }
    }

    @Override
    public boolean checkAdminRole(User user){
        //1 for user, 2 for administer
        return user.getRole().equals(2);
    }


}
