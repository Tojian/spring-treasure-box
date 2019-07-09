package com.taojian.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TaoSpringcloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaoSpringcloudEurekaClientApplication.class, args);
    }

}
