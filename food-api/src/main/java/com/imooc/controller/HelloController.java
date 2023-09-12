package com.imooc.controller;

import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "Hello", tags = {"Hello"})
@RestController
@RequestMapping("hello")
public class HelloController {

    @ApiOperation(value = "查询用户收货地址列表", notes = "查询用户收货地址列表", httpMethod = "GET")
    @GetMapping("/index")
    public JSONResult list() {
        System.out.println("Hello");
        return JSONResult.ok();
    }
}