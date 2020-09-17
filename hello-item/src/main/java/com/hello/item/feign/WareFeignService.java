package com.hello.item.feign;

import com.hello.commons.domain.R;
import com.hello.commons.vo.SkuHasStockVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("hello-ware")
public interface WareFeignService {

    @PostMapping("/waresku/hasstock")
    R<List<SkuHasStockVO>> getSkusHasStock(@RequestBody List<Long> skuIds);

}
