package com.hello.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

