package com.undancer.app;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @GetMapping(path = "/")
    public Object get() {
        Map<String, Object> returnObject = Maps.newHashMap();
        returnObject.put("username", "undancer");
        return returnObject;
    }
}
