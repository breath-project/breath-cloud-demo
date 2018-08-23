package com.undancer.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import zipkin2.server.internal.EnableZipkinServer

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringCloudApplication
//@EnableZipkinServer
@EnableZipkinServer
class TrackApplication : SpringBootServletInitializer() {

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder
    }

}

fun main(args: Array<String>) {
    runApplication<TrackApplication>(*args) {

    }
}