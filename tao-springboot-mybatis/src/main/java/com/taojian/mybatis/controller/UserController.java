package com.taojian.mybatis.controller;

import com.taojian.mybatis.bean.User;
import com.taojian.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: taojian
 * @create: 2018-12-29 20:50
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="testinsert")
    public String testInsert(){
        User user = new User();
        user.setUserId(1);
        user.setPhone("133333333");
        user.setUserName("taojian");
        user.setPassword("123");
        userService.insert(user);
        return null;
    }
}
