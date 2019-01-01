package com.taojian.mybatis.service;

import com.taojian.mybatis.bean.User;
import com.taojian.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: taojian
 * @create: 2018-12-30 13:45
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }
}
