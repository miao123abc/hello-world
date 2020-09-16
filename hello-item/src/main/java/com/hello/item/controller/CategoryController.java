package com.hello.item.controller;

import com.hello.commons.domain.R;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.CategoryEntity;
import com.hello.item.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@RestController
@RequestMapping("category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 树形列表
     */
    @RequestMapping("/list/tree")
    // @RequiresPermissions("item:category:list")
    public R listTree() {
        List<CategoryEntity> categoryEntities = categoryService.listTree();

        return R.ok(categoryEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("item:category:list")
    public R list(@RequestBody Map<String, Object> params) {
        log.info("params = [" + params + "]");
        PageUtils page = categoryService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("item:category:info")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);
        return R.ok(category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("item:category:save")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("item:category:update")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("item:category:delete")
    public R delete(@RequestBody Long[] catIds) {
        categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
