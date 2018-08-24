package com.undancer.cloud.admin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication

@EnableAdminServer
@SpringCloudApplication
class AdminApplication

fun main(args: Array<String>) {
    runApplication<AdminApplication>(*args) {

    }
}