package com.hello.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

