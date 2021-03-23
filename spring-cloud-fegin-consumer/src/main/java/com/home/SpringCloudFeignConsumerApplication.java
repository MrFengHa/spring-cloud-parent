package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableFeignClients 启用Feign客户端
 *
 * @Author 冯根源
 * @create 2021/3/23 11:50
 */
@EnableFeignClients
@SpringBootApplication
public class SpringCloudFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignConsumerApplication.class,args);
    }
}
