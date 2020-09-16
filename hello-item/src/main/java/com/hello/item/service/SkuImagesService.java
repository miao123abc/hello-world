package com.hello.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.SkuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * sku图片
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuImagesEntity> getImagesBySkuId(Long skuId);
}

