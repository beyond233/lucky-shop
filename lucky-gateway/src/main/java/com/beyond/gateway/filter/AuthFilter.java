package com.beyond.gateway.filter;

import com.beyond.common.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * description: 网关鉴权
 *
 * @author beyond233
 * @since 2021/2/22 23:43
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    @Resource
    private RedisService redisService;

    /**
     * 权限过滤
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从request中获取名称为username的请求参数
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        // 判断username是否为空
        if (username == null) {
            log.info("参数username不能为空！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 通过请求，转发路由
        return chain.filter(exchange);
    }

    /**
     * 顺序规则
     * */
    @Override
    public int getOrder() {
        return 0;
    }
}
