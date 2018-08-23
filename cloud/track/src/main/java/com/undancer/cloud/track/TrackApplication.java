package com.undancer.cloud.track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringCloudApplication
//@EnableZipkinServer
@EnableZipkinServer
public class TrackApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrackApplication.class, args);
    }

}
