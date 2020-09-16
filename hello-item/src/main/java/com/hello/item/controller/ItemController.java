package com.hello.item.controller;

import com.hello.commons.domain.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("item/")
public class ItemController {

    @Value("${user.userName}")
    private String userName;

    @GetMapping("config")
    public R configDemo(){
        return R.ok(userName);
    }
}
