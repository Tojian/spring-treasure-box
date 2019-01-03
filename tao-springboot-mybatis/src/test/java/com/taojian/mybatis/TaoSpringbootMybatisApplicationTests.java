package com.taojian.mybatis;

import com.taojian.mybatis.bean.User;
import com.taojian.mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaoSpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert(){
        User user = new User();
        user.setUserId(3);
        user.setPhone("133333333");
        user.setUserName("taojian");
        user.setPassword("123");
        userMapper.insert(user);
    }

}

