package com.undancer.cloud.dashboard

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class IndexController {

    @RequestMapping(path = ["/"])
    fun home(): String {
        return "forward:/hystrix"
    }

}