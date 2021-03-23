package com.home.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2021/3/23 22:45
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //返回当前过滤器的类型，决定当前过滤器在什么时候执行
        //pre表示在目标微服务之前执行
        String filterType = "pre";
        return filterType;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断当前请求是否要过滤
     * 要过滤 返回true继续执行run方法
     * 不过滤 返回false直接放行
     *
     * @return
     */
    public boolean shouldFilter() {
        //获取RequestContext对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = requestContext.getRequest();

        //判断当前请求参数是否为signal=hello
        String parameter = request.getParameter("signal");


        return "hello".equals(parameter);
    }

    /**
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        System.err.println("当前请求要进行过滤,run()方法执行");
        return null;
    }
}
