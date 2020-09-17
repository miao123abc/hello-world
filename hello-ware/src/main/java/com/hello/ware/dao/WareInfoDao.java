package com.hello.ware.dao;

import com.hello.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author miao
 * @email 
 * @date 2020-09-17 16:04:28
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
