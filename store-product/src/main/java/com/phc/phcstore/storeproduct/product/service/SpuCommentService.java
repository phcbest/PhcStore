package com.phc.phcstore.storeproduct.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storeproduct.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-21 17:35:50
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

