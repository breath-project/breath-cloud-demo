package com.undancer.cloud.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.ServletContextRequestLoggingFilter
import javax.servlet.Filter

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
class ConfigApplication : SpringBootServletInitializer() {

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder
    }

    @Bean
    fun requestLoggingFilter(): Filter {
        return ServletContextRequestLoggingFilter()
    }

}

fun main(vararg args: String) {
    runApplication<ConfigApplication>(*args) {

    }
}
