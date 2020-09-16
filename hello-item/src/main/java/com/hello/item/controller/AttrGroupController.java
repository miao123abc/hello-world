package com.hello.item.controller;

import com.hello.commons.utils.PageUtils;
import com.hello.commons.domain.R;
import com.hello.item.entity.AttrGroupEntity;
import com.hello.item.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 属性分组
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@RestController
@RequestMapping("attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("item:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    // @RequiresPermissions("item:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        return R.ok(attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("item:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("item:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("item:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
