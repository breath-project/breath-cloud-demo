package com.undancer.cloud.admin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
class AdminApplication

fun main(vararg args: String) {
    runApplication<AdminApplication>(*args) {

    }
}