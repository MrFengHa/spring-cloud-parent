package com.home.controller;

import com.home.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 职工接口类
 *
 * @Author 冯根源
 * @create 2021/3/22 17:07
 */
@RestController
public class EmployeeController {
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        //获取当亲Web应用的端口号
        int serverPort = request.getServerPort();

        return new Employee(555, "tom555-"+serverPort, 555.55);
    }
}
