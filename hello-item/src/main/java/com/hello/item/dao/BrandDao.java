package com.hello.item.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.item.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
