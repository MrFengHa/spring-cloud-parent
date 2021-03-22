package com.home.config;

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

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
