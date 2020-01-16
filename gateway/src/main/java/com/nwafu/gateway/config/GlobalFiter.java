package com.nwafu.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.nwafu.gateway.classes.ResponseMessage;
import com.nwafu.gateway.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: rabbitManagement
 * @description: 全局的过滤器
 * @author: liu qinchang
 * @create: 2020-01-16 10:55
 **/
@Component
@Slf4j
public class GlobalFiter implements GlobalFilter, Ordered {

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getPath().toString();
        log.info("ip：{}, 路径：{}",exchange.getRequest().getRemoteAddress(), url);
        String[] path = url.split("/");
        if(url.split("/")[1].equals("actions")){
            if(!redisUtils.isUserExit(url.split("/")[3])){
                ResponseMessage<Integer> responseMessage = new ResponseMessage<>("未登录，没有操作权限", -1);
                ServerHttpResponse response = exchange.getResponse();
                DataBuffer buffer = response.bufferFactory().wrap(JSONObject.toJSONBytes(responseMessage));
                response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                log.warn("拦截url: {}, 没有权限", url);
                return response.writeWith(Mono.just(buffer));
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
