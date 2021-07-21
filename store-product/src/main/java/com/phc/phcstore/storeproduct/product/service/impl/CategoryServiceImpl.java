package com.phc.phcstore.storeproduct.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;
import com.phc.phcstore.storeproduct.product.dao.CategoryDao;
import com.phc.phcstore.storeproduct.product.entity.CategoryEntity;
import com.phc.phcstore.storeproduct.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
//        查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
//        组装成为父子结构
        //找到所有的一级分类
        List<CategoryEntity> level1Menus = categoryEntities.stream().filter(new Predicate<CategoryEntity>() {
            @Override
            public boolean test(CategoryEntity categoryEntity) {
                return categoryEntity.getParentCid() == 0;
            }
        }).map((menu) -> {
            menu.setChildren(getChildren(menu, categoryEntities));
            return menu;
        }).sorted((o1, o2) -> (o1.getSort() == null ? 0 : o1.getSort()) - (o2.getSort() == null ? 0 : o2.getSort()))
                .collect(Collectors.toList());

        return level1Menus;
    }

    /***
     * // TODO: 2021/7/21  检查当前菜单是否被引用
     * 在数据库操作中，最好使用逻辑删除，而不是物理删除
     * 逻辑删除 ，指在数据库中做一个标志位，而不是真正的删除了该条数据
     * @param asList
     */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(new Predicate<CategoryEntity>() {
            @Override
            public boolean test(CategoryEntity categoryEntity) {
                return categoryEntity.getParentCid().equals(root.getCatId());
            }
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((o1, o2) -> (o1.getSort() == null ? 0 : o1.getSort()) - (o2.getSort() == null ? 0 : o2.getSort()))
                .collect(Collectors.toList());

        return children;
    }

}