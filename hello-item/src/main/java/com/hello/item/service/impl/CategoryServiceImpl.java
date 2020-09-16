package com.hello.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.commons.utils.PageUtils;
import com.hello.commons.domain.Query;
import com.hello.item.dao.CategoryDao;
import com.hello.item.entity.CategoryEntity;
import com.hello.item.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listTree() {
        List<CategoryEntity> categoryEntities = list();

        return categoryEntities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek(categoryEntity ->
                        categoryEntity.setChildren(getChildren(categoryEntities, categoryEntity.getCatId()))
                ).sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());
    }

    /**
     * 查找子类菜单
     *  @param categoryEntities 分类全部数据
     * @param pid 需要查找的父类菜单id
     */
    private List<CategoryEntity> getChildren(List<CategoryEntity> categoryEntities, Long pid) {
        return categoryEntities.stream()
                .filter(catagory -> pid.equals(catagory.getParentCid()))
                .peek(catagory -> catagory.setChildren(getChildren(categoryEntities, catagory.getCatId())))
                .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                .collect(Collectors.toList());
    }

}