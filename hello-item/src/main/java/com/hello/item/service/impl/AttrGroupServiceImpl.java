package com.hello.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.commons.utils.PageUtils;
import com.hello.commons.domain.Query;
import com.hello.item.dao.AttrGroupDao;
import com.hello.item.entity.AttrGroupEntity;
import com.hello.item.service.AttrGroupService;
import com.hello.item.vo.SpuItemAttrGroupVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuIdAndCatalogId(Long spuId, Long catalogId) {
        return this.baseMapper.getAttrGroupWithAttrsBySpuIdAndCatalogId(spuId, catalogId);
    }

}