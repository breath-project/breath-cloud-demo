package com.undancer.app;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public Object home() {
        Map<String, Object> resultObject = Maps.newHashMap();
        resultObject.put("username", "undancer");
        return resultObject;
    }

}
