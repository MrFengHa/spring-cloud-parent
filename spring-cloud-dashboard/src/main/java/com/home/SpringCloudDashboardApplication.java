package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * 启用Hystrix仪表盘
 * EnableHystrixDashboard 启用仪表盘监控功能
 * @Author 冯根源
 * @create 2021/3/23 17:36
 */
@EnableHystrixDashboard
@SpringBootApplication
public class SpringCloudDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDashboardApplication.class,args);
    }
}
