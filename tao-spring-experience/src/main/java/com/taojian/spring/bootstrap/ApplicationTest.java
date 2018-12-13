package com.taojian.spring.bootstrap;

import com.taojian.spring.bean.MyBean;
import com.taojian.spring.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: taojian
 * @create: 2018-12-09 10:22
 **/
public class ApplicationTest {


    public static void main(String[] args) {
        // 以注解的形式把 bean 注入Spring 并获取 Spring 的上下文环境
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

        // 获取自己配置的 bean 实例
        MyBean myBean = ctx.getBean(MyConfig.class).getMyBean();

        System.out.println("MyBean ID ----- >> "+myBean.getId());

    }

}
