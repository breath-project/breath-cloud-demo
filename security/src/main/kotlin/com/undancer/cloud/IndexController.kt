package com.undancer.cloud

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping(path = ["/hello"])
class IndexController {
    @GetMapping
    fun home(request: HttpServletRequest): Any {
        var token = request.userPrincipal as OAuth2AuthenticationToken
        return token.principal.attributes
//        return "hello"
    }
}