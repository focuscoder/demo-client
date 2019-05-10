package com.example.client.democlient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages = {"com.example.*"})
@EnableEurekaClient
@MapperScan("com.example.client.democlient.order.dao")
public class DemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }

}
