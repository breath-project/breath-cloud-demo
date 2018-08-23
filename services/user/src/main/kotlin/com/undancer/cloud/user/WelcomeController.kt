package com.undancer.cloud.user

import com.netflix.config.sources.URLConfigurationSource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path = ["/"])
class WelcomeController {

    @GetMapping
    fun welcome(): String {
//        return "forward:/user"

        return "redirect:/user"
    }

}