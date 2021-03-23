package com.home.controller;

import com.home.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 职工接口类
 *
 * @Author 冯根源
 * @create 2021/3/22 17:07
 */
@RestController
@Slf4j
public class EmployeeController {
    @RequestMapping("/provider/get/employee/remote/feignTest")
    public Employee getEmployeeRemote() {

        return new Employee(555, "tom555", 555.55);
    }


    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        //获取当亲Web应用的端口号
        int serverPort = request.getServerPort();

        return new Employee(555, "tom555-" + serverPort, 555.55);
    }

    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {
        log.error("keyword" + keyword);
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            int num = i * 100 + i * 10 + i;
            employeeList.add(new Employee(num, "tom" + num, num + (i * 0.1 + i * 0.01)));
        }
        return employeeList;
    }

}
