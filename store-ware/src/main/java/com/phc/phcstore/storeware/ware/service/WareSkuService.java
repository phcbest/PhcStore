package com.phc.phcstore.storeware.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storeware.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:39:14
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

