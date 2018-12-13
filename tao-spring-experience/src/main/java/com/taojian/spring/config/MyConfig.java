package com.taojian.spring.config;

import com.taojian.spring.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: taojian
 * @create: 2018-12-09 10:19
 **/
@Configuration
public class MyConfig {

    @Bean
    public MyBean getMyBean(){
        return new MyBean();
    }

}
