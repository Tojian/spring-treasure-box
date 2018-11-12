/*
 * Copyright (C) 2018 Tao Jian. All Rights Reserved.
 */
package com.taojian.activemq;


import com.taojian.activemq.client.ActiveMQClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ServerApplication {

    @Autowired
    ActiveMQClient client;

    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            client.send("发送消息----hello-----");
        }
        stopWatch.stop();
        System.out.println("发送消息耗时: " + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}

