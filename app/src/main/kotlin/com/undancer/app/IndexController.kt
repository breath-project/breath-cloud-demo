package com.undancer.app

import com.google.common.collect.Maps
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping(path = ["/"])
    fun get(): Any {
        val returnObject = Maps.newHashMap<String, Any>()
        returnObject["username"] = "undancer"
        return returnObject
    }
}
