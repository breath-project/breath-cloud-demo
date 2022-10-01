package com.undancer.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SecurityApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<SecurityApplication>(*args)
}