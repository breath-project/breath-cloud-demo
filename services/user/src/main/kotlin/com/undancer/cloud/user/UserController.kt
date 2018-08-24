package com.undancer.cloud.user

import com.google.common.collect.Maps
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/user"])
class UserController {

    @GetMapping
    fun get(): Any {
        val resultObject = Maps.newHashMap<String, Any>()
        resultObject["username"] = "undancer"
        return resultObject
    }

}
