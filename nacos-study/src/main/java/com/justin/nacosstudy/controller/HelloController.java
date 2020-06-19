package com.justin.nacosstudy.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("测试接口")
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
