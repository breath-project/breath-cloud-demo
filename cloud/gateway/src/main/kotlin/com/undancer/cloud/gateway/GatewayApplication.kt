package com.undancer.cloud.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class GatewayApplication

fun main(vararg args: String) {
    runApplication<GatewayApplication>(*args) {

    }
}