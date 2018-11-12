package com.taojian.activemq.server;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: taojian
 * @create: 2018-11-12 20:11
 **/
@Component
public class ActiveMQServer {
    @JmsListener(destination = "hello")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }
}