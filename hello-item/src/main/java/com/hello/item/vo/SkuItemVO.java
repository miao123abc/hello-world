package com.hello.item.vo;

import com.hello.item.entity.SkuImagesEntity;
import com.hello.item.entity.SkuInfoEntity;
import com.hello.item.entity.SpuInfoDescEntity;
import lombok.Data;

import java.util.List;

/**
 * 商品详情页面数据
 */
@Data
public class SkuItemVO {

    private SkuInfoEntity info;

    private boolean hasStock;

    private List<SkuImagesEntity> images;

    private List<SkuItemSaleAttrVO> saleAttr;

    private SpuInfoDescEntity desp;

    private List<SpuItemAttrGroupVO> groupAttrs;

    private SeckillInfoVO seckillInfo;

}
