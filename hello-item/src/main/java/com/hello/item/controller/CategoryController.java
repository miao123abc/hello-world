package com.hello.item.controller;

import com.hello.commons.utils.PageUtils;
import com.hello.commons.utils.R;
import com.hello.item.entity.CategoryEntity;
import com.hello.item.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    /**
     * 树形列表
     */
    @RequestMapping("/list/tree")
    // @RequiresPermissions("item:category:list")
    public R listTree() {
        List<CategoryEntity> categoryEntities = categoryService.listTree();

        return R.ok().put("data", categoryEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("item:category:list")
    public R list(@RequestBody Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);
        logger.info("params = [" + params + "]");
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("item:category:info")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);
        return R.ok().put("category", category);
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
