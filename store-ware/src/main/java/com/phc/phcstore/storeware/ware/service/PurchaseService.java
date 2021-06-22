package com.phc.phcstore.storeware.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storeware.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:39:14
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

