package com.home.controller;

import com.home.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 冯根源
 * @create 2021/3/22 17:59
 */
@RestController
public class HumanResourceController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/ribbon/get/employee")
    public Employee getEmployeeRemote() {
        //1.声明远程微服务主机地址加端口号
        //String host = "http://localhost:1000";

        //将运城微服务调用地址从“IP地址+端口号”改成“微服务名称”
        String host ="http://rootFeng-provider";
        //2.声明具体要调用的URl功能
        String url = "/provider/get/employee/remote";

        //3.restTemplate调用远程微服务
        return restTemplate.getForObject(host + url, Employee.class);

    }
}
