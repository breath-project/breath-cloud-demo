package com.undancer.cloud.gateway

import com.google.common.collect.Maps
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/"])
class IndexController {

    @GetMapping
    fun home(): Any {
        val resultObject = Maps.newHashMap<String, Any>()
        resultObject["path"] = "gateway"
        return resultObject
    }

}
