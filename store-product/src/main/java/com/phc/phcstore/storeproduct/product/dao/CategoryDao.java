package com.phc.phcstore.storeproduct.product.dao;

import com.phc.phcstore.storeproduct.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-21 17:35:50
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
