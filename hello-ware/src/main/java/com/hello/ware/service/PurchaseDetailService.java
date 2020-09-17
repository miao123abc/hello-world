package com.hello.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

