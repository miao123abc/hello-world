package com.hello.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

