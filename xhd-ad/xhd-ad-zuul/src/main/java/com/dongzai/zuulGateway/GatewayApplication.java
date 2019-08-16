package com.dongzai.zuulGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 作者: xhd
 * 创建时间: 2019/8/16 10:10
 * 版本: V1.0
 */
@SpringCloudApplication
@EnableZuulProxy //启用网关
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
