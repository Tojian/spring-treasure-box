/*
 * Copyright (C) 2018 Tao Jian. All Rights Reserved.
 */
package com.taojian.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: taojian
 * @create: 2018-10-21 21:37
 **/
@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/setValue")
    public String setValue(){
        if(!template.hasKey("taojian")){
            template.opsForValue().append("shabao", "hello");
            return "使用redis缓存保存数据成功";
        }else{
            template.delete("taojian");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    public String getValue(){

        if(!template.hasKey("taojian")){
            return "key不存在，请先保存数据";
        }else{
            String shabao = template.opsForValue().get("taojian");//根据key获取缓存中的val
            return "获取到缓存中的数据：shabao="+shabao;
        }
    }

}

