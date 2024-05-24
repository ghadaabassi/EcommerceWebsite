package com.micro.gatewayservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableDiscoveryClient
public class DynamicRoutingConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/products/**")
                        .uri("lb://product-service"))
                .route("order-service", r -> r.path("/orders/**")
                        .uri("lb://order-service"))
                .route("inventory-service", r -> r.path("/inventory/**")
                        .uri("lb://inventory-service"))
                .build();
    }
}