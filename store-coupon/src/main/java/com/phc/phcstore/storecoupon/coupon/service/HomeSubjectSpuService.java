package com.phc.phcstore.storecoupon.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storecoupon.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 11:15:45
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

