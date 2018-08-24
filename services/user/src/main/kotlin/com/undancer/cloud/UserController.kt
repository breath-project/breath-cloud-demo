package com.undancer.cloud

import com.google.common.collect.Maps
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/user"])
class UserController {

    @GetMapping
    @HystrixCommand()
    fun get(): Any {
        val resultObject = Maps.newHashMap<String, Any>()
        resultObject["username"] = "undancer"
        return resultObject
    }

}
