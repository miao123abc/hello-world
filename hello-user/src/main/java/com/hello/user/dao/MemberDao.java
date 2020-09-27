package com.hello.user.dao;

import com.hello.user.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author miao
 * @email 
 * @date 2020-09-24 10:31:34
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
