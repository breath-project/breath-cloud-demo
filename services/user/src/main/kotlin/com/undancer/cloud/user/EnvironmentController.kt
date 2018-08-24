package com.undancer.cloud.user

import com.google.common.collect.Maps
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/user/env"])
class EnvironmentController {

    @Value("\${foo}")
    private val username: String? = null

    @GetMapping
    fun home(): Any {
        val resultObject = Maps.newHashMap<String, Any>()
        resultObject["username"] = username
        return resultObject
    }

}