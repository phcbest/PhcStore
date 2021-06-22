package com.phc.phcstore.storeorder.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storeorder.order.entity.PaymentInfoEntity;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:30:28
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

