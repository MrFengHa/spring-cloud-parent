package com.home.api;

import com.home.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * FeignClient注解 表示当前接口和一个Provider对应，注解中value属性指定要调用Provider的微服务名称
 *
 * @Author 冯根源
 * @create 2021/3/23 11:30
 */
@FeignClient("rootFeng-provider")
public interface EmployeeRemoteService {

    /**
     * 远程调用的接口方法，
     * 要@RequestMapping注解映射的地址一致
     * 要求方法声明一致
     * 用来获取请求参数的@requestParam、@PathVariable、@RequestBody不能省略
     * 两边一致
     * @return
     */
    @RequestMapping("/provider/get/employee/remote/feignTest")
    Employee getEmployeeRemote();

    /**
     * 测试带参数的Feign
     * @param keyword
     * @return
     */
    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);
}
