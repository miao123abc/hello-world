package com.hello.item.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.item.entity.SkuSaleAttrValueEntity;
import com.hello.item.vo.SkuItemSaleAttrVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVO> getSaleAttrsBySpuId(@Param("spuId") Long spuId);
}
