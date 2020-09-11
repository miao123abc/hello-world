package com.hello.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/sayHello")
    public String sayHello(@RequestParam("name") String name){
        return "Hello：" + name;
    }
}
