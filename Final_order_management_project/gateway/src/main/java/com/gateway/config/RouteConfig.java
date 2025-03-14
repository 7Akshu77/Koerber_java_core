package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/products/**")
                        .filters(f -> f.rewritePath("/products/(?<segment>.*)", "/${segment}"))
                        .uri("http://product-service:8000")) // Change port if needed

                .route("order-service", r -> r.path("/orders/**")
                        .filters(f -> f.rewritePath("/orders/(?<segment>.*)", "/${segment}"))
                        .uri("http://order-service:8001"))

                .route("inventory-service", r -> r.path("/inventory/**")
                        .filters(f -> f.rewritePath("/inventory/(?<segment>.*)", "/${segment}"))
                        .uri("http://inventory-service:8002"))

                .route("notification-service", r -> r.path("/notification/**")
                        .filters(f -> f.rewritePath("/notification/(?<segment>.*)", "/${segment}"))
                        .uri("http://notification-service:8084"))

                .build();
    }
}
