package com.home.api;

import com.home.entity.Employee;
import com.home.factory.MyFallbackFactory;
import com.home.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * FeignClient注解 表示当前接口和一个Provider对应，注解中value属性指定要调用Provider的微服务名称
 *  fallbackFactory属性 指定Provider不可用时提供备用方案的工厂类型
 * @Author 冯根源
 * @create 2021/3/23 11:30
 */
@FeignClient(value = "rootFeng-provider", fallbackFactory = MyFallbackFactory.class)
public interface EmployeeRemoteService {

    /**
     * 远程调用的接口方法，
     * 要@RequestMapping注解映射的地址一致
     * 要求方法声明一致
     * 用来获取请求参数的@requestParam、@PathVariable、@RequestBody不能省略
     * 两边一致
     *
     * @return
     */
    @RequestMapping("/provider/get/employee/remote/feignTest")
    Employee getEmployeeRemote();

    /**
     * 测试带参数的Feign
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);

    /**
     * 获取熔断接口
     *
     * @param signal
     * @return
     */
    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);
}
