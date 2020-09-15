package com.hello.item.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.item.entity.SpuInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * spu信息
 * 
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {
	
}
