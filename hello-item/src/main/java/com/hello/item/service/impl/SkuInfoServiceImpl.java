package com.hello.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.commons.domain.Query;
import com.hello.commons.utils.PageUtils;
import com.hello.item.dao.SkuInfoDao;
import com.hello.item.entity.SkuImagesEntity;
import com.hello.item.entity.SkuInfoEntity;
import com.hello.item.entity.SpuInfoDescEntity;
import com.hello.item.service.*;
import com.hello.item.vo.SeckillInfoVO;
import com.hello.item.vo.SkuItemSaleAttrVO;
import com.hello.item.vo.SkuItemVO;
import com.hello.item.vo.SpuItemAttrGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Resource
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Resource
    private AttrGroupService attrGroupService;

    @Autowired
    private SkuImagesService imagesService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * TODO CompletableFuture 异步编排
     * @param skuId 商品sku id
     */
    @Override
    public SkuItemVO item(Long skuId) {
        SkuItemVO skuItemVO = new SkuItemVO();
        // sku 基本信息
        SkuInfoEntity skuInfo = getById(skuId);
        Long spuId = skuInfo.getSpuId();
        skuItemVO.setInfo(skuInfo);

        // spu 的销售属性组合
        List<SkuItemSaleAttrVO> saleAttrVOS = skuSaleAttrValueService.getSaleAttrsBySpuId(spuId);
        skuItemVO.setSaleAttr(saleAttrVOS);

        // spu 介绍
        SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);
        skuItemVO.setDesp(spuInfoDesc);

        // spu 的规格参数信息
        List<SpuItemAttrGroupVO> attrGroupVOS = attrGroupService.getAttrGroupWithAttrsBySpuIdAndCatalogId(spuId, skuInfo.getCatalogId());
        skuItemVO.setGroupAttrs(attrGroupVOS);

        // sku 图片信息
        List<SkuImagesEntity> images = imagesService.getImagesBySkuId(skuId);
        skuItemVO.setImages(images);

        // TODO sku 秒杀信息
        skuItemVO.setSeckillInfo(new SeckillInfoVO());

        return skuItemVO;
    }

}