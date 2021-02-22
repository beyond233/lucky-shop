package com.beyond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: lucky shop gateway application
 *
 * @author beyond233
 * @since 2021/2/22 23:10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LuckyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LuckyGatewayApplication.class, args);
    }
}
