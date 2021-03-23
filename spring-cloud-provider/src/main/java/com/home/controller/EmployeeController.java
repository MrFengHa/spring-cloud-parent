package com.home.controller;

import com.home.entity.Employee;
import com.home.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            int num = i * 100 + i * 10 + i;
            employeeList.add(new Employee(num, "tom" + num, num + (i * 0.1 + i * 0.01)));
        }
        return employeeList;
    }

    /**
     * HystrixCommand 注解指定当前方法出问题时调用备份方法
     * @param signal
     * @return
     * @throws InterruptedException
     */
    @HystrixCommand(fallbackMethod = "getEmpWithCircuitBreakerBackUp")
    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal) throws InterruptedException {
        String qb = "quick bang";
        if (qb.equals(signal)) {
            throw new RuntimeException();
        }
        String sb = "slow bang";
        if (sb.equals(signal)) {
            Thread.sleep(5000);
        }
        return ResultEntity.ok().data(new Employee(666, "empName666", 666.66));
    }

    public ResultEntity<Employee> getEmpWithCircuitBreakerBackUp(@RequestParam("signal") String signal) {
        return ResultEntity.error("失败了");

    }


}
