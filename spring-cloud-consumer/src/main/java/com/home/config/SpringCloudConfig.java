package com.home.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2021/3/22 17:55
 */
@Configuration
public class SpringCloudConfig {

    /**
     * LoadBalanced 让RestTemplate有负载均衡的功能，通过Ribbon访问Provider集群
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
