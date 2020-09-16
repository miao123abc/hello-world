package com.hello.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.AttrGroupEntity;
import com.hello.item.vo.SpuItemAttrGroupVO;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuIdAndCatalogId(Long skuId, Long catalogId);
}

