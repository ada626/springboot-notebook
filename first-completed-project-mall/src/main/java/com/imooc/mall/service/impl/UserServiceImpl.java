package com.imooc.mall.service.impl;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
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
    @Override
    public void register(String username, String password) throws MallException {
        //查询用户名是否存在，不允许重名
        User result = userMapper.selectByUserName(username);
        if(result!=null){
            throw new MallException(MallExceptionEnum.USERNAME_EXISTED);
        }
        //写到数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count = userMapper.insertSelective(user);
        if(count==0){
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }
}
