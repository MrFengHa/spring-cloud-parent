package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * EnableZuulProxy 开启zuul代理
 *
 * @author 冯根源
 * @date 2021/3/23 21:59
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudZuulApplication.class,args);
    }
}
