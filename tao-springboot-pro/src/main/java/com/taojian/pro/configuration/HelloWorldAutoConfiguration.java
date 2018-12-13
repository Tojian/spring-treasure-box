package com.taojian.pro.configuration;


import com.taojian.pro.annotation.EnableHelloWorld;
import com.taojian.pro.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "Mercy") // 条件装配
public class HelloWorldAutoConfiguration {
}
