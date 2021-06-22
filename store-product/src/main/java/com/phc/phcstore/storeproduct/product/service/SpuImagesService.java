package com.phc.phcstore.storeproduct.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storeproduct.product.entity.SpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-21 17:35:50
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

