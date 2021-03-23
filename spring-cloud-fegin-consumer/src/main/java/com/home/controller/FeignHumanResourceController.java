package com.home.controller;

import com.home.api.EmployeeRemoteService;
import com.home.entity.Employee;
import com.home.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2021/3/23 11:54
 */
@RestController
public class FeignHumanResourceController {
    /**
     * 装配调用远程微服务接口，后面调用本地方法一样直接使用
     */
    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemote(){
        return employeeRemoteService.getEmployeeRemote();
    }

    @RequestMapping("/feign/consumer/search")
    public List<Employee> getEmpListRemote(String keyword){

        return employeeRemoteService.getEmpListRemote(keyword);
    }

    @RequestMapping("/feign/consumer/get/fallback")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal){

        return employeeRemoteService.getEmpWithCircuitBreaker(signal);
    }



}
