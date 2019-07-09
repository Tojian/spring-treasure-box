package com.taojian.cas.service.impl;

import com.taojian.cas.dao.UserMapper;
import com.taojian.cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangsaichao
 * @date: 2018/8/1
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(String username) {
        userMapper.insert(username, "123456");
    }
}
