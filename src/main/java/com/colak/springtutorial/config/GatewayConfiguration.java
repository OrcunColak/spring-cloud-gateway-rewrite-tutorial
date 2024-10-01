package com.colak.springtutorial.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orders", r -> r.path("/orders/*") // Match incoming requests to /orders/*
                        .filters(f -> f
                                .rewritePath("/orders/(?<segment>.*)", "/forders/${segment}") // Rewrite the path
                        )
                        .uri("http://localhost:8080")) // Forward to the ignored endpoint
                .build();
    }

}

