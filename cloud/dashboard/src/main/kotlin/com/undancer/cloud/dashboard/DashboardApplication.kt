package com.undancer.cloud.dashboard

import com.undancer.cloud.dashboard.stream.MockStreamServlet
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableEurekaClient
//@EnableHystrixDashboard
class DashboardApplication : SpringBootServletInitializer() {

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder
    }

    @Bean
    fun mockStreamServlet(): ServletRegistrationBean<*> {
        return ServletRegistrationBean(MockStreamServlet(), "/mock.stream")
    }

}

fun main(args: Array<String>) {
    runApplication<DashboardApplication>(*args) {

    }
}