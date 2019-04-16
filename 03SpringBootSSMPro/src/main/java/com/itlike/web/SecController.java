package com.itlike.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecController {
    @Value("${name}")
    String name;

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }
}
