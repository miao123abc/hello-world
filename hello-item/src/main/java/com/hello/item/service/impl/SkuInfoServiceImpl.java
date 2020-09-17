package com.hello.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.commons.domain.Query;
import com.hello.commons.domain.R;
import com.hello.commons.utils.PageUtils;
import com.hello.commons.vo.SkuHasStockVO;
import com.hello.item.dao.SkuInfoDao;
import com.hello.item.entity.SkuImagesEntity;
import com.hello.item.entity.SkuInfoEntity;
import com.hello.item.entity.SpuInfoDescEntity;
import com.hello.item.feign.WareFeignService;
import com.hello.item.service.*;
import com.hello.item.vo.SeckillInfoVO;
import com.hello.item.vo.SkuItemSaleAttrVO;
import com.hello.item.vo.SkuItemVO;
import com.hello.item.vo.SpuItemAttrGroupVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;


@Service("skuInfoService")
@Slf4j
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Resource
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Resource
    private AttrGroupService attrGroupService;

    @Autowired
    private SkuImagesService imagesService;

    @Resource
    private WareFeignService wareFeignService;

    @Autowired
    private ThreadPoolExecutor poolExecutor;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * CompletableFuture 异步编排
     *      CompletableFuture 默认使用ForkJoinPool线程池，利用分治思想，适用于计算密集型任务
     *      不适于IO密集型，商品详情多是查询数据库，所以自己指定了线程池
     * @param skuId 商品skuId
     */
    @Override
    public SkuItemVO item(Long skuId) throws ExecutionException, InterruptedException {
        SkuItemVO skuItemVO = new SkuItemVO();
        // sku 基本信息
        CompletableFuture<SkuInfoEntity> skuInfoFuture = CompletableFuture.supplyAsync(() -> {
            SkuInfoEntity skuInfo = getById(skuId);
            skuItemVO.setInfo(skuInfo);
            return skuInfo;
        }, poolExecutor);

        // spu 的销售属性组合
        CompletableFuture<Void> saleAttrFuture = skuInfoFuture.thenAcceptAsync((skuInfoEntity) -> {
            List<SkuItemSaleAttrVO> saleAttrVOS = skuSaleAttrValueService.getSaleAttrsBySpuId(skuInfoEntity.getSpuId());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            skuItemVO.setSaleAttr(saleAttrVOS);
        }, poolExecutor);

        // spu 介绍
        CompletableFuture<Void> spuInfoFuture = skuInfoFuture.thenAcceptAsync((skuInfoEntity) -> {
            SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(skuInfoEntity.getSpuId());
            skuItemVO.setDesp(spuInfoDesc);
        }, poolExecutor);

        // spu 的规格参数信息
        CompletableFuture<Void> attrGroupFuture = skuInfoFuture.thenAcceptAsync((skuInfoEntity) -> {
            List<SpuItemAttrGroupVO> attrGroupVOS =
                    attrGroupService.getAttrGroupWithAttrsBySpuIdAndCatalogId(skuInfoEntity.getSpuId(), skuInfoEntity.getCatalogId());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            skuItemVO.setGroupAttrs(attrGroupVOS);
        }, poolExecutor);

        // sku 图片信息
        CompletableFuture<Void> imagesFuture = CompletableFuture.runAsync(() -> {
            List<SkuImagesEntity> images = imagesService.getImagesBySkuId(skuId);
            skuItemVO.setImages(images);
        }, poolExecutor);

        // sku的库存信息
        CompletableFuture<Void> storeFuture = CompletableFuture.runAsync(() -> {
            R<List<SkuHasStockVO>> skusHasStock = wareFeignService.getSkusHasStock(Collections.singletonList(skuId));
            List<SkuHasStockVO> hasStockData = skusHasStock.getData();
            if (!CollectionUtils.isEmpty(hasStockData)) {
                skuItemVO.setHasStock(hasStockData.get(0).getHasStock());
            }
        }, poolExecutor).exceptionally(e -> {
            log.error("skuId：{}商品详情，库存查询异常：{}", skuId, e.getMessage());
            skuItemVO.setHasStock(false);
            return null;
        });

        // TODO feign远程调用查询 sku 秒杀信息
        CompletableFuture<Void> seckillInfoFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            skuItemVO.setSeckillInfo(new SeckillInfoVO());
        }, poolExecutor);

        CompletableFuture.allOf(saleAttrFuture, spuInfoFuture, attrGroupFuture, imagesFuture, storeFuture, seckillInfoFuture).get();
        return skuItemVO;
    }

}