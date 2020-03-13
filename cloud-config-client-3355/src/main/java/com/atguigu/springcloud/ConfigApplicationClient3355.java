package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigApplicationClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplicationClient3355.class,args);
    }
}
