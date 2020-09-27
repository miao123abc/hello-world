package com.hello.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hello.commons.utils.PageUtils;
import com.hello.user.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author miao
 * @email 
 * @date 2020-09-24 10:31:34
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

