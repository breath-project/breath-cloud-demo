package com.undancer.cloud

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.client.SpringCloudApplication

@SpringCloudApplication
class UserApplication : SpringBootServletInitializer() {

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder
    }

}

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args) {
    }
}