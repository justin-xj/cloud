package com.justin.nacosstudy.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value(value = "${test.justin}")
    private String justin;

    @Autowired
    private ApplicationContext context;

    @ApiOperation("测试接口")
    @RequestMapping("/hello")
    public String hello(){
        return justin;
    }

    @RequestMapping("/shutdown")
    public String shutdown(){
        ShutdownEndpoint shutdownEndpoint = new ShutdownEndpoint();
        shutdownEndpoint.setApplicationContext(context);
        shutdownEndpoint.shutdown();
        return "success";
    }
}
