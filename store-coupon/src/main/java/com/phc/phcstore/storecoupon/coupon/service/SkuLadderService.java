package com.phc.phcstore.storecoupon.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storecoupon.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 11:15:45
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

