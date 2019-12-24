package com.nwafu.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @program: rabbitmanagement
 * @description: 过滤器
 * @author: liu qinchang
 * @create: 2019-12-24 15:18
 **/
public class MyFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run(){
        return null;
    }
}
