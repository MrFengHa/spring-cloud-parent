package com.home.controller;

import com.home.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职工接口类
 *
 * @Author 冯根源
 * @create 2021/3/22 17:07
 */
@RestController
public class EmployeeController {
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {
        return new Employee(555, "tom555", 555.55);
    }
}
