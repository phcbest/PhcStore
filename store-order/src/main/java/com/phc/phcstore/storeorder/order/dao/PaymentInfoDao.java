package com.phc.phcstore.storeorder.order.dao;

import com.phc.phcstore.storeorder.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:30:28
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
