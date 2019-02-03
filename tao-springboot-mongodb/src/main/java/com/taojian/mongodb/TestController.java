package com.taojian.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: taojian
 * @create: 2019-02-03 19:25
 **/
@RestController
public class TestController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String testList() throws Exception {
        User user = new User();
        user.setId(2L);
        user.setUserName("taojian");
        user.setPassWord("taojian");
        userRepository.saveUser(user);

        return "ok";
    }

}