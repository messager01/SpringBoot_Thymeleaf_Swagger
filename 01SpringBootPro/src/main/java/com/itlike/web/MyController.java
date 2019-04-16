package com.itlike.web;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * use:
 * date:
 */


@RestController
public class MyController {
    @Autowired
    private DataSource dataSource;
    @RequestMapping("/hello")
    public String hello(){
        System.out.println(dataSource);
        return "hello Spring Boot123456 what the hell";
    }
}
