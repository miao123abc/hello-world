package com.hello.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.SkuInfoEntity;
import com.hello.item.vo.SkuItemVO;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 商品详情
     */
    SkuItemVO item(Long skuId) throws InterruptedException, ExecutionException;
}

