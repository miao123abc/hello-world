package com.hello.item.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.item.entity.AttrGroupEntity;
import com.hello.item.vo.SpuItemAttrGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性分组
 * 
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@Mapper
public interface AttrGroupDao extends BaseMapper<AttrGroupEntity> {

    List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuIdAndCatalogId(@Param("spuId") Long spuId,
                                                                      @Param("catalogId") Long catalogId);
}
