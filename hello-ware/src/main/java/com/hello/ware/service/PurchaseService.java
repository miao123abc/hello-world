package com.hello.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

