package com.undancer.cloud.gateway

import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean

//@Configuration
class RouteConfiguration {

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                .route("path_route") { r ->
                    r.path("/get")
                            .uri("http://httpbin.org")
                }
                .route("host_route") { r ->
                    r.host("*.myhost.org")
                            .uri("http://httpbin.org")
                }
                .route("rewrite_route") { r ->
                    r.host("*.rewrite.org")
                            .filters { f ->
                                f.rewritePath("/foo/(?<segment>.*)",
                                        "/\${segment}")
                            }
                            .uri("http://httpbin.org")
                }
//                .route("hystrix_route") { r ->
//                    r.host("*.hystrix.org")
//                            .filters { f -> f.hystrix { c -> c.name = "slowcmd" } }
//                            .uri("http://httpbin.org")
//                }
//                .route("hystrix_fallback_route") { r ->
//                    r.host("*.hystrixfallback.org")
//                            .filters { f -> f.hystrix { c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback") } }
//                            .uri("http://httpbin.org")
//                }
//                .route("limit_route") { r ->
//                    r
//                            .host("*.limited.org").and().path("/anything/**")
//                            .filters { f -> f.requestRateLimiter { c -> c.rateLimiter = redisRateLimiter() } }
//                            .uri("http://httpbin.org")
//                }
                .route("websocket_route") { r ->
                    r.path("/echo")
                            .uri("ws://localhost:9000")
                }
                .route("rewrite_route_edit") { r ->
                    r.alwaysTrue()
                            .filters { f ->
                                f.rewritePath("/foo/(?<segment>.*)",
                                        "/\${segment}")
                            }
                            .uri("http://httpbin.org:3200")
                }
                .route("user") { r ->
                    r.path("/user").uri("lb://user")
                }
                .build()
    }

    @Bean
    fun redisRateLimiter(): RedisRateLimiter {
        return RedisRateLimiter(1, 2)
    }

}