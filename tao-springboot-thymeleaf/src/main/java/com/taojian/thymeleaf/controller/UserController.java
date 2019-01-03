package com.taojian.thymeleaf.controller;

import java.util.List;

import com.taojian.thymeleaf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * @description:
 * @author: taojian
 * @create: 2019-01-03 19:40
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(Model model) throws Exception {
        model.addAttribute("title", "用户列表");
        model.addAttribute("hello","Hello, Spring Boot!");
        List<User> userList = new ArrayList<>();
        userList.add(new User("小明", 25));
        userList.add(new User("小黄", 23));
        model.addAttribute("userList", userList);

        return "/user/list";
    }
}
