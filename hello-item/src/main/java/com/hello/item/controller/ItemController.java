package com.hello.item.controller;

import com.hello.commons.domain.R;
import com.hello.item.service.SkuInfoService;
import com.hello.item.vo.SkuItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RefreshScope
@RequestMapping("item/")
public class ItemController {

    @Value("${user.userName}")
    private String userName;

    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("config")
    public R configDemo(){
        return R.ok(userName);
    }

    @GetMapping("/{skuId}")
    public R item(@PathVariable("skuId") Long skuId) {
        SkuItemVO skuItemVO = skuInfoService.item(skuId);
        return R.ok(skuItemVO);
    }
}
