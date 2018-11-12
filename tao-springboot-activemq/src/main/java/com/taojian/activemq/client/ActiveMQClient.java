package com.taojian.activemq.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: taojian
 * @create: 2018-11-12 20:11
 **/
@Component
public class ActiveMQClient {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message) {
        jmsTemplate.convertAndSend("hello", message);
    }
}
