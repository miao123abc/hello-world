package com.hello.item.controller;

import com.hello.commons.domain.R;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.SpuCommentEntity;
import com.hello.item.service.SpuCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 商品评价
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@RestController
@RequestMapping("spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("item:spucomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuCommentService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("item:spucomment:info")
    public R info(@PathVariable("id") Long id){
		SpuCommentEntity spuComment = spuCommentService.getById(id);

        return R.ok(spuComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("item:spucomment:save")
    public R save(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.save(spuComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("item:spucomment:update")
    public R update(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.updateById(spuComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("item:spucomment:delete")
    public R delete(@RequestBody Long[] ids){
		spuCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
