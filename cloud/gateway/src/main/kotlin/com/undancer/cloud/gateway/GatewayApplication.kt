package com.undancer.cloud.gateway

import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication

@SpringCloudApplication
class GatewayApplication

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args) {

    }
}