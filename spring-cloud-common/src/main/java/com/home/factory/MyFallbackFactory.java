package com.home.factory;

import com.home.api.EmployeeRemoteService;
import com.home.entity.Employee;
import com.home.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实现Consumer端服务降级功能
 * 实现FallbackFactory接口时要传入@FeignClient注解标记的接口的类型
 * 在create()方法中返回@FeignClient注解标记的接口类型的对象，当Provider调用失败后，会执行这个对象的对应的方法
 *
 * @Author 冯根源
 * @create 2021/3/23 16:43
 */
@Component
public class MyFallbackFactory implements FallbackFactory<EmployeeRemoteService> {

    @Override
    public EmployeeRemoteService create(final Throwable throwable) {
        return new EmployeeRemoteService() {
            @Override
            public Employee getEmployeeRemote() {
                return null;
            }

            @Override
            public List<Employee> getEmpListRemote(String keyword) {
                return null;
            }

            /**
             * 获取熔断接口
             *
             * @param signal
             * @return
             */
            @Override
            public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
                return ResultEntity.error("降级机制生效" + throwable.getMessage());
            }
        };
    }
}
