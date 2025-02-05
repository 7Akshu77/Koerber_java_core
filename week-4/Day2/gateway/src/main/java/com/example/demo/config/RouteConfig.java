package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/currency-applicaton/exchange/**")
                        .filters(f -> f.rewritePath("/currency-applicaton/exchange/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CURRENCY-EXCHANGE"))  // ✅ Using Eureka Load Balancer

                .route(p -> p
                        .path("/currency-applicaton/conversion/**")
                        .filters(f -> f.rewritePath("/currency-applicaton/conversion/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CURRENCY-CONVERSION"))
                .build();
    }
}
