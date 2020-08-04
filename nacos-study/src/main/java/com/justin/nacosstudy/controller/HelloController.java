package com.justin.nacosstudy.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value(value = "${test.justin}")
    private String justin;

    @ApiOperation("测试接口")
    @RequestMapping("/hello")
    public String hello(){
        return justin;
    }
}
